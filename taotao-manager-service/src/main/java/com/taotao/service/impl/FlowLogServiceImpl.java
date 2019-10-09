package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbFlowLogMapper;
import com.taotao.service.FlowLogService;

@Service
public class FlowLogServiceImpl implements FlowLogService {

	@Autowired
	TbFlowLogMapper tbFlowLogMapper;
	
	BaseResult baseResult = new BaseResult();
	
	
	
}
