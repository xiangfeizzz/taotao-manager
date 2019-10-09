package com.taotao.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.service.FlowConfService;

@Service
public class FlowConfServiceImpl implements FlowConfService {

	@Autowired
	TbFlowConfMapper tbFlowConfMapper;
	
	BaseResult baseResult = new BaseResult();

	@Override
	public Map<String, Object> getFlowConfInfo(Map<String, String> map, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getFlowConfList(Map<String, String> map, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
