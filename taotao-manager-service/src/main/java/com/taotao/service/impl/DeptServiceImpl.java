package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbDeptMapper;
import com.taotao.pojo.TbDept;
import com.taotao.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	TbDeptMapper tbDeptMapper;
	BaseResult baseResult = new BaseResult();
	
	@Override
	public Map<String, Object> getDeptList(HttpServletRequest request) {
		List<TbDept> deptList = tbDeptMapper.selectByExample(null);
		return baseResult.getSuccMap(deptList);
	}

}
