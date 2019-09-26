package com.taotao.common.enums;

public enum FlowStatus {
	flowStatus_0("0","待审核"),
	flowStatus_1("1","审核中"),
	flowStatus_2("2","审核通过"),
	flowStatus_3("3"," 审核拒绝");
	
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
	
	FlowStatus(String code,String desc){ 
		this.code=code;
		this.desc=desc;
	}
	
	public static String getValue(String code){
		for (FlowStatus type : values()) {
			if(type.getCode().equals(code)){
				return type.getDesc();
			}
		}
		return null;
	}
}
