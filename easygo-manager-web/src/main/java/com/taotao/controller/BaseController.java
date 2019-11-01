package com.taotao.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.taotao.common.redis.JeditCommon;

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
    
    
    @RequestMapping(value = "page/redisLoad")
  	public String reload(){
    	InputStream in;
		HashMap<String,String> resourceMap=new HashMap<>();
        try{
        	Properties prop = new Properties();     
        	File file = ResourceUtils.getFile("classpath:resource/resource.properties");
            in = new BufferedInputStream (new FileInputStream(file));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
            	String key=it.next();
	               resourceMap.put(key, prop.getProperty(key));
	            }
        	in.close();
	        }catch (Exception e) {
				e.printStackTrace();
			}
        JeditCommon.init(resourceMap.get("redis_addr"), Integer.parseInt(resourceMap.get("redis_port")), resourceMap.get("redis_password"));
        JeditCommon.set("resourceMap", JSONObject.toJSONString(resourceMap));
        return "redisload ok!";
  	}
    
}
