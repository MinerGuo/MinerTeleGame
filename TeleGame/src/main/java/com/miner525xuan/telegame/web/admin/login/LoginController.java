package com.miner525xuan.telegame.web.admin.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miner525xuan.telegame.dao.BUserDao;
import com.miner525xuan.telegame.db.model.BUser;
import com.miner525xuan.telegame.enums.ActionStatus;
import com.miner525xuan.telegame.enums.BUserStatus;
import com.miner525xuan.telegame.utils.Constant;
import com.miner525xuan.telegame.utils.StringDealUtil;

@Controller
public class LoginController {

	@Autowired
	private BUserDao userDao;

	@RequestMapping("/admin/login")
	public String login(HttpSession httpSession, Model model, BUser puser) {
		// 清空所有登录信息
		httpSession.removeAttribute(Constant.LOGIN_KEY);

		return "/admin/login";
	}

	@ResponseBody
	@RequestMapping("/admin/doLogin")
	public Map<String, String> doLogin(HttpSession httpSession, Model model, String loginName, String password) {
		Map<String, String> result = new HashMap<String, String>();

		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			result.put(Constant.ACTION_STATUS, "0");
			result.put(Constant.ACTION_MESSAGE, "登录名或密码不能为空！");
			return result;

		}

		BUser puser = new BUser();
		puser.setLoginName(loginName);
		List<BUser> userList = userDao.selectList(puser);
		if (userList == null || userList.size() != 1) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "登录名或密码错误！");
			return result;
		}
		BUser user = userList.get(0);

		if (!StringDealUtil.getMD5(user.getId() + Constant.PASSWORD_SPLIT + password).equals(user.getPassword())) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "登录名或密码错误！");

			// 递增密码错误次数
			user.setTryCount(StringDealUtil.getIntFromInteger(user.getTryCount()) + 1);
			if (user.getTryCount() >= 5) {
				user.setStatus(1);
			}
			userDao.update(user);
			return result;
		}

		if (user.getStatus() == BUserStatus.Locked.getCode()) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "帐号已锁定，请联系管理员！");
			return result;
		}
		if (user.getStatus() == BUserStatus.Forbid.getCode()) {
			result.put(Constant.ACTION_STATUS, ActionStatus.FAILED.getCode());
			result.put(Constant.ACTION_MESSAGE, "帐号已禁用，请联系管理员！");
			return result;
		}

		// 错误尝试次数清零
		user.setTryCount(0);
		user.setStatus(0);
		userDao.update(user);

		// 加载菜单资源

		// 保存登录用户信息
		httpSession.setAttribute(Constant.LOGIN_KEY, user);

		result.put(Constant.ACTION_STATUS, ActionStatus.SUCCESS.getCode());
		result.put(Constant.ACTION_MESSAGE, "登录成功！");

		return result;

	}

}
