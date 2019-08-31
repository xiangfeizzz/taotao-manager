package com.taotao.filter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONObject;
import com.taotao.common.redis.JeditCommon;

@Service
public class ApiFilter implements Filter {
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
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
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}