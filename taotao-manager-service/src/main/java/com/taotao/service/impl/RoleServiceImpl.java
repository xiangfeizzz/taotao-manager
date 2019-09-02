package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbRoleMapper;
import com.taotao.pojo.TbRole;
import com.taotao.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	TbRoleMapper tbRoleMapper;
	BaseResult baseResult = new BaseResult();
	
	@Override
	public Map<String, Object> getRoleList(HttpServletRequest request) {
		List<TbRole> roleList = tbRoleMapper.selectByExample(null);
		return baseResult.getSuccMap(roleList);
	}

}
