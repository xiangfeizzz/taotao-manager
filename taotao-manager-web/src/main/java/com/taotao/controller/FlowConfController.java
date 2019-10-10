package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.FlowConfService;

@Controller
@RequestMapping("/flowConf")
public class FlowConfController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FlowConfController.class);
	
	@Autowired
	FlowConfService flowConfService;
	
	@ModelAttribute
	public void setWebPrefix(HttpServletRequest request) {
		request.setAttribute("basePrefix", "user");
	}
	
	@RequestMapping("/getFlowConfInfo")
	@ResponseBody
	public Map<String,Object>  getFlowConfInfo(@RequestBody Map<String,String> map,HttpServletRequest request) {
		return flowConfService.getFlowConfInfo(map,request);
	}
	
	@RequestMapping("/getFlowConfList")
	@ResponseBody
	public Map<String,Object>  getFlowConfList(@RequestBody Map<String,String> map,HttpServletRequest request) {
		return flowConfService.getFlowConfList(map,request);
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public Map<String,Object>  del(@RequestBody Map<String,String> map) {
		return flowConfService.del(map);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,Object>  add(@RequestBody Map<String,String> map) {
		return flowConfService.add(map);
	}
	
	@RequestMapping("/upd")
	@ResponseBody
	public Map<String,Object>  upd(@RequestBody Map<String,String> map) {
		return flowConfService.upd(map);
	}
	
}
