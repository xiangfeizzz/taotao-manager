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

import com.taotao.service.HolidayService;

@Controller
@RequestMapping("/holiday")
public class HolidayController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HolidayController.class);
	
	@Autowired
	HolidayService holidayService;
	
	@ModelAttribute
	public void setWebPrefix(HttpServletRequest request) {
		request.setAttribute("basePrefix", "user");
	}
	
	@RequestMapping("/holidayAdd")
	@ResponseBody
	public Map<String,Object>  holidayAdd(@RequestBody Map<String,String> map) {
		return holidayService.holidayAdd(map);
	}
	
	
}
