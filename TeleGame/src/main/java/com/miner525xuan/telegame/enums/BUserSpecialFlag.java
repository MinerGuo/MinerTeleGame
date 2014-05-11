package com.miner525xuan.telegame.enums;

public enum BUserSpecialFlag {
	Normal(0, "����"), Privilege(1, "��Ȩ");

	private BUserSpecialFlag(Integer code, String desc) {
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
