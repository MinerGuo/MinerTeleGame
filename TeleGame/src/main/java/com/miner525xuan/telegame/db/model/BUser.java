package com.miner525xuan.telegame.db.model;

import java.io.Serializable;
import java.util.Date;

import com.miner525xuan.telegame.dao.BasePrimaryFetch;

public class BUser implements Serializable, BasePrimaryFetch<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -603543750437410597L;

	private Integer id;
	private String loginName;
	private String password;
	private Integer tryLoginCount;
	private char specialFlag;
	private Date lastLoginTime;
	private Integer status;
	private Date createTime;
	private Date lastUpdateTime;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTryCount() {
		return tryLoginCount;
	}

	public void setTryCount(Integer tryCount) {
		this.tryLoginCount = tryCount;
	}

	public char getSpecialFlag() {
		return specialFlag;
	}

	public void setSpecialFlag(char specialFlag) {
		this.specialFlag = specialFlag;
	}

	public Date getLastLogin() {
		return lastLoginTime;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLoginTime = lastLogin;
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

	public Integer getTryLoginCount() {
		return tryLoginCount;
	}

	public void setTryLoginCount(Integer tryLoginCount) {
		this.tryLoginCount = tryLoginCount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getPrimaryKey() {
		return id;
	}

}
