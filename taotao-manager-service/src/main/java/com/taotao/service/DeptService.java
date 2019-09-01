package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface DeptService {

	Map<String, Object> getDeptList(HttpServletRequest request);
}
