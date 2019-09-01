package com.taotao.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.PositionService;


@Controller
public class PositionController {
	private static final Logger logger = LoggerFactory.getLogger(PositionController.class);
	
	@Autowired
	PositionService positionService;
	
	
	@RequestMapping("/position/getPositionList")
	@ResponseBody
	public Map<String,Object>  getPositionList(HttpServletRequest request) {
		Map<String,Object> resultMap=positionService.getPositionList(request);
		return resultMap;
	}
}
