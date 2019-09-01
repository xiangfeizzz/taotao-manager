package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.BaseResult;
import com.taotao.mapper.TbPositionMapper;
import com.taotao.pojo.TbPosition;
import com.taotao.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	TbPositionMapper tbPositionMapper;
	BaseResult baseResult = new BaseResult();

	@Override
	public Map<String, Object> getPositionList(HttpServletRequest request) {
		List<TbPosition> positionList = tbPositionMapper.selectByExample(null);
		return baseResult.getSuccMap(positionList);
	}


}
