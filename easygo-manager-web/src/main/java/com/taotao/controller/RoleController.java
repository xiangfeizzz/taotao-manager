package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.RoleService;


@Controller
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleService roleService;
	
	
	@RequestMapping("/role/getRoleList")
	@ResponseBody
	public Map<String,Object>  getRoleList(HttpServletRequest request) {
		Map<String,Object> resultMap=roleService.getRoleList(request);
		return resultMap;
	}
	
	
}
