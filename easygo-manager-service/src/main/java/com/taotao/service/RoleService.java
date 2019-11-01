package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface RoleService {

	Map<String, Object> getRoleList(HttpServletRequest request);
}
