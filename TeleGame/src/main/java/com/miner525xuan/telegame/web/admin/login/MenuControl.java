package com.miner525xuan.telegame.web.admin.login;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miner525xuan.telegame.dao.BMenuDao;
import com.miner525xuan.telegame.db.model.BMenu;
import com.miner525xuan.telegame.enums.ActionStatus;
import com.miner525xuan.telegame.utils.Constant;

@Controller
public class MenuControl {

	@Autowired
	private BMenuDao menuDao;

	@RequestMapping("/admin/menu/index")
	public String index(HttpSession httpSession, Model model) {

		BMenu menu = new BMenu();
		menu.setParentID(-1);

		// 显示所有一级菜单
		List<BMenu> menuList = menuDao.selectList(menu);
		model.addAttribute("menuList", menuList);

		return "/admin/menu/index";
	}

	@RequestMapping("/admin/menu/edit")
	public String edit(HttpSession httpSession, Model model, Integer menuId) {

		String page = "/admin/menu/edit";

		if (menuId == null) {
			model.addAttribute(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			model.addAttribute(Constant.ACTION_MESSAGE, "参数错误！");
			return page;

		}
		BMenu menu = menuDao.selectOneByPK(menuId);
		if (menu == null) {
			model.addAttribute(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			model.addAttribute(Constant.ACTION_MESSAGE, "未找到指定菜单！");
			return page;

		}

		model.addAttribute("menuInfo", menu);

		return page;
	}

	@ResponseBody
	@RequestMapping("/admin/menu/editDo")
	public Map<String, String> editDo(HttpSession httpSession, @RequestBody BMenu menu) {

		Map<String, String> result = new HashMap<String, String>();

		if (menu == null || menu.getId() == null) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "缺少参数！");
			return result;
		}

		menu.setLastUpdateTime(new Date());
		menuDao.update(menu);

		result.put(Constant.ACTION_STATUS, ActionStatus.SUCCESS.getCode());

		return result;
	}

	@ResponseBody
	@RequestMapping("/admin/menu/sigleInfo")
	public Map<String, Object> sigleInfo(HttpSession httpSession, Integer menuId) {

		Map<String, Object> result = new HashMap<String, Object>();

		if (menuId == null) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "参数错误！");
			return result;

		}
		BMenu menu = menuDao.selectOneByPK(menuId);
		if (menu == null) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "未找到指定菜单！");
			return result;

		}
		
		
		result.put(Constant.ACTION_STATUS, ActionStatus.SUCCESS.getCode());
		result.put(Constant.ACTION_DATA, menu);

		return result;
	}
	
	
	@RequestMapping("/admin/menu/add")
	public String add(HttpSession httpSession, Model model,Integer level) {

		String page = "/admin/menu/add";
		
		model.addAttribute("level",level);

		return page;
	}
	
	
	@ResponseBody
	@RequestMapping("/admin/menu/addDo")
	public Map<String, String> addDo(HttpSession httpSession, @RequestBody BMenu menu) {

		Map<String, String> result = new HashMap<String, String>();

		if (menu == null) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "缺少参数！");
			return result;
		}
		
		
		menu.setCreateTime(new Date());
		menu.setLastUpdateTime(new Date());
		menu.setChildCount(0);
		menuDao.insert(menu);

		result.put(Constant.ACTION_STATUS, ActionStatus.SUCCESS.getCode());

		return result;
	}
}
