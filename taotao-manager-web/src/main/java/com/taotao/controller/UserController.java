package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/changePwd")
	@ResponseBody
	public Map<String,Object>  changePwd(@RequestBody Map<String,String> map) {
	    return userService.changePwd(map);
	}
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Map<String,Object>  getUserInfo(@RequestBody Map<String,String> map) {
	    return userService.getUserInfo(map);
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public Map<String,Object>  getUserList(@RequestBody Map<String,String> map,HttpServletRequest request) {
	    return userService.getUserList(map,request);
	}
	
	@RequestMapping("/userDel")
	@ResponseBody
	public Map<String,Object>  userDel(@RequestBody Map<String,String> map) {
		return userService.userDel(map);
	}
	
	@RequestMapping("/userAdd")
	@ResponseBody
	public Map<String,Object>  userAdd(@RequestBody Map<String,String> map) {
		return userService.userAdd(map);
	}
	
	@RequestMapping("/userUpd")
	@ResponseBody
	public Map<String,Object>  userUpd(@RequestBody Map<String,String> map) {
		return userService.userUpd(map);
	}
	
}
