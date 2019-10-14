package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FlowCheckService {

	Map<String, Object> add(Map<String, String> map,HttpServletRequest request);

}
