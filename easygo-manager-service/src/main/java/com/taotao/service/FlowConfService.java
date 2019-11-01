package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FlowConfService {

	Map<String, Object> getFlowConfInfo(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> getFlowConfList(Map<String, String> map, HttpServletRequest request);

	Map<String, Object> del(Map<String, String> map);

	Map<String, Object> add(Map<String, String> map);

	Map<String, Object> upd(Map<String, String> map);
	

}
