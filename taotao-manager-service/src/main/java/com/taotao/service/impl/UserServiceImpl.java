package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.utils.ShaUtil;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbMenuMapperCust;
import com.taotao.pojo.TbMenu;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.service.UserService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午10:47:14
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbMenuMapperCust tbMenuMapperCust;
	

	@Override
	public Map<String, Object> checkPassword(HttpServletRequest request) {
		BaseResult baseResult = new BaseResult();
		String password = request.getParameter("password");
		String loginName =request.getParameter("loginName");
		//添加查询条件
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbUser user = list.get(0);
			String pwd = user.getPassword();
			String sha256Pass =ShaUtil.encode(password,"");
			if(pwd.equals(sha256Pass)){
				return baseResult.getSuccMap();
			}else{
				return baseResult.getErrorJsonObj("密码不正确");
			}
		}else{
			return baseResult.getErrorJsonObj("用户不存在");
		}
	}
	
}
