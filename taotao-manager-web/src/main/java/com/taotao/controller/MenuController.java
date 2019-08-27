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

import com.taotao.service.MenuService;
import com.taotao.service.UserService;


@Controller
public class MenuController {
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	MenuService menuService;
	
	
	@RequestMapping("/menu/getMenuList")
	@ResponseBody
	public Map<String,Object>  getMenuList(HttpServletRequest request) {
		Map<String,Object> resultMap=menuService.getMenuList(request);
		return resultMap;
	}
	
	
}
