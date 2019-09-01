package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PositionService {

	Map<String, Object> getPositionList(HttpServletRequest request);
}
