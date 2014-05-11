package com.miner525xuan.telegame.enums;

public enum BUserStatus {

	Normal(0, "正常"), Locked(1, "锁定"), Forbid(2, "禁用");

	private BUserStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Integer code;
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
