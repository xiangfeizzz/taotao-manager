package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FlowService {
	
	Map<String, Object> getFlowInfo(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> getFlowList(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> holidayAdd(Map<String, String> map,HttpServletRequest request);

	Map<String, Object> workextAdd(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> flowDel(Map<String, String> map);

	Map<String, Object> flowBack(Map<String, String> map);

	Map<String, Object> flowSubmit(Map<String, String> map);

	Map<String, Object> holidayUpd(Map<String, String> map);

	Map<String, Object> workextUpd(Map<String, String> map);

}
