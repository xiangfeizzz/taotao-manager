package com.taotao.common.pojo;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class BaseResult {
	
	public final static String SUCCESS_CODE = "000000";
	
	public final static String ERROR_CODE = "-1";
	
	public final static String SUCCESS_MSG = "success";
    
    
    /**
	 * 返回成功JSON
	 * @return
	 */
	public JSONObject getSuccessJsonObj() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("resultCode", SUCCESS_CODE);
		jsonObject.put("resultMsg", SUCCESS_MSG);
		return jsonObject;
	}
	
	public String getSuccessResult() {
		return getSuccessJsonObj().toJSONString();
	}
	
	public JSONObject getErrorJsonObj(String errmsg) {
		return getErrorJsonObj(ERROR_CODE, errmsg);
	}
	
	/**
	 * 返回失败JSON
	 * @param code
	 * @param errmsg
	 * @return
	 */
	public JSONObject getErrorJsonObj(String code, String errmsg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("resultCode", code);
		jsonObject.put("resultMsg", errmsg);
		return jsonObject;
	}
	
	public String getErrorResult(String code, String errmsg) {
		return getErrorJsonObj(code, errmsg).toJSONString();
	}
	
	public String getErrorResult(String errmsg) {
		return getErrorResult(ERROR_CODE, errmsg);
	}
	
	public Map<String,Object> getSuccMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resultCode", SUCCESS_CODE);
		map.put("resultMsg", SUCCESS_MSG);
		
		return map;
	}
	public Map<String,Object> getSuccMap(Object data){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resultCode", SUCCESS_CODE);
		map.put("resultMsg", SUCCESS_MSG);
		map.put("data", data);
		
		return map;
	}
	
	public Map<String,Object> getErrorMap(String msg){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resultCode", ERROR_CODE);
		map.put("resultMsg", msg);
		
		return map;
	}
}
