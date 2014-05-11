package com.miner525xuan.telegame.db.model;

import java.io.Serializable;
import java.util.Date;

import com.miner525xuan.telegame.dao.BasePrimaryFetch;

public class BMenu implements Serializable, BasePrimaryFetch<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 300744526652244132L;
	
	
	private Integer id;
	private String menuName;
	private String url;
	private Integer orderNum;
	private Integer parentID;
	private Integer childCount;
	private Integer status;
	private Date createTime;
	private Date lastUpdateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public Integer getPrimaryKey() {
		return id;
	}

}
