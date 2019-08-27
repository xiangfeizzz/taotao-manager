package com.taotao.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@ModelAttribute
	public void setWebPrefix(HttpServletRequest request) {
		request.setAttribute("basePrefix", "home");
	}
	
	
}
