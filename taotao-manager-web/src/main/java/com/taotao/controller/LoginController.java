package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.redis.JeditCommon;
import com.taotao.service.UserService;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/login")
	public String login() {
		return "user/loginUI";
	}
	
	@RequestMapping("/loginOut")
	public String showIndex(HttpServletRequest request) {
		HttpSession session =request.getSession(); 
		String sessionId = session.getId();
		JeditCommon.del(sessionId);
		return "user/loginUI";
	}
	
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public Map<String,Object>  doLogin(HttpServletRequest request) {
		Map<String,Object> resultMap=userService.doLogin(request);
		return resultMap;
	}
	
	
}
