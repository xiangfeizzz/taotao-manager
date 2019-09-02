package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface MenuService {

	Map<String, Object> getMenuList(HttpServletRequest request);
}
