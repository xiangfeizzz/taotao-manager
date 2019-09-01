package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	Map<String, Object> changePwd(Map<String,String> map);

	Map<String, Object> getUserInfo(Map<String,String> map);

	Map<String, Object> getUserList(Map<String,String> map,HttpServletRequest request);
	
	Map<String, Object> userDel(Map<String,String> map);

	Map<String, Object> doLogin(HttpServletRequest request);

	Map<String, Object> userAdd(Map<String, String> map);

	Map<String, Object> userUpd(Map<String, String> map);
}
