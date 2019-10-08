package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FlowService {
	
	Map<String, Object> getFlowInfo(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> getFlowList(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> holidayAdd(Map<String, String> map,HttpServletRequest request);

	Map<String, Object> workextAdd(Map<String, String> map, HttpServletRequest request);

}
