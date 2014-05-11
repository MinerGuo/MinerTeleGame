package com.miner525xuan.telegame.enums;

public enum ActionStatus {

	FAILED("0", "ʧ��"), SUCCESS("1", "�ɹ�"), ;

	private ActionStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
