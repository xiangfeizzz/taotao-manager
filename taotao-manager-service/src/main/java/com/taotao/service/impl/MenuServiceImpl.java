package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbMenuMapperCust;
import com.taotao.pojo.TbMenu;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	TbMenuMapperCust tbMenuMapperCust;
	@Autowired
	TbUserMapper tbUserMapper;
	BaseResult baseResult = new BaseResult();
	
	@Override
	public Map<String, Object> getMenuList(HttpServletRequest request) {
		String loginName =request.getParameter("loginName");
		HashMap<String, Object> loadLoginData = this.loadLoginData(loginName);
		return baseResult.getSuccMap(loadLoginData);
	}
	
	private HashMap<String, Object> loadLoginData(String loginName) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		TbUser user = list.get(0);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		//一级菜单
		List<TbMenu> headerList = tbMenuMapperCust.selectByRoleId(loginName,"1");
		//二级菜单
		List<TbMenu> menuList = tbMenuMapperCust.selectByRoleId(loginName,"2");

		Object arr1 = JSONArray.toJSON(headerList);
		Object arr2 = JSONArray.toJSON(menuList);
		map.put("loginName", user.getLoginName());
		map.put("userName", user.getUserName());
		map.put("userId", user.getUserId()); 
		map.put("headerList", arr1.toString());
		map.put("menuList", arr2.toString());
		return map;
	}


}
