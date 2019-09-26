package com.taotao.common.enums;

public enum FlowType {
	flowType_1("1","请假申请"),
	flowType_2("2","加班申请"),
	flowType_3("3","出差申请"),
	flowType_4("4","离职申请"),
	flowType_5("5","物品申领"),
	flowType_6("6","报销申请");
	
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
	
	FlowType(String code,String desc){ 
		this.code=code;
		this.desc=desc;
	}
	
	public static String getValue(String code){
		for (FlowType type : values()) {
			if(type.getCode().equals(code)){
				return type.getDesc();
			}
		}
		return null;
	}

}
