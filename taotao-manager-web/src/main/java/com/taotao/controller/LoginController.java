package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String showIndex() {
		return "user/loginUI";
	}
	
	
	@RequestMapping("/login/checkPassword")
	@ResponseBody
	public Map<String,Object>  checkPassword(HttpServletRequest request) {
		Map<String,Object> resultMap=userService.checkPassword(request);
		return resultMap;
	}
	
	
}
