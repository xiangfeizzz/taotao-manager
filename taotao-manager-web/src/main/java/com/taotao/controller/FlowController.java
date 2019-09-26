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

import com.taotao.service.FlowService;

@Controller
@RequestMapping("/flow")
public class FlowController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FlowController.class);
	
	@Autowired
	FlowService flowService;
	
	@ModelAttribute
	public void setWebPrefix(HttpServletRequest request) {
		request.setAttribute("basePrefix", "user");
	}
	
	@RequestMapping("/getFlowList")
	@ResponseBody
	public Map<String,Object>  getFlowList(@RequestBody Map<String,String> map,HttpServletRequest request) {
		return flowService.getFlowList(map,request);
	}
}
