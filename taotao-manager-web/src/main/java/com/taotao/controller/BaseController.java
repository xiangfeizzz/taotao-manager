package com.taotao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
    @RequestMapping(value = "page/{optType}")
	public String pageRedirect(@PathVariable String optType,Model model,HttpServletRequest request){
		String preffix = request.getParameter("preffix");
		
		for(Object key : request.getParameterMap().keySet()) {
			model.addAttribute(key.toString(), request.getParameter(key.toString()));
		}
		
		request.setAttribute("basePrefix", preffix);
		return preffix + "/" + optType;
	}
    
}
