package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	Map<String, Object> checkPassword(HttpServletRequest request);
}
