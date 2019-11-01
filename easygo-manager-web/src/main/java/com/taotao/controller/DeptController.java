package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.DeptService;


@Controller
public class DeptController {
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	DeptService deptService;
	
	
	@RequestMapping("/dept/getDeptList")
	@ResponseBody
	public Map<String,Object>  getDeptList(HttpServletRequest request) {
		Map<String,Object> resultMap=deptService.getDeptList(request);
		return resultMap;
	}
}
