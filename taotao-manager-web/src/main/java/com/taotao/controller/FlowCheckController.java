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

import com.taotao.service.FlowCheckService;

@Controller
@RequestMapping("/flowCheck")
public class FlowCheckController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FlowCheckController.class);
	
	@Autowired
	FlowCheckService flowCheckService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Object>  add(@RequestBody Map<String,String> map,HttpServletRequest request) {
		return flowCheckService.add(map,request);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object>  list(@RequestBody Map<String,String> map,HttpServletRequest request) {
		return flowCheckService.list(map,request);
	}
	
}
