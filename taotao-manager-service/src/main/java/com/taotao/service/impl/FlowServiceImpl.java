package com.taotao.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.enums.FlowStatus;
import com.taotao.common.enums.FlowType;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.redis.JeditCommon;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.mapperCust.TbFlowMapperCust;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbUser;
import com.taotao.service.FlowService;

@Service
public class FlowServiceImpl implements FlowService {

	@Autowired
	TbFlowMapper tbFlowMapper;
	@Autowired
	TbFlowMapperCust tbFlowMapperCust;
	BaseResult baseResult = new BaseResult();
	
	
	@Override
	public Map<String, Object> holidayAdd(Map<String, String> map ,HttpServletRequest request) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			TbFlow flow = objectMapper.convertValue(map, TbFlow.class);
			flow.setCreateTime(DateUtil.getDateAndTime());
			String startTime = flow.getHolidayStartTime();
			String endTime = flow.getHolidayEndTime();
  			if(StringUtils.isNotBlank(startTime)){
  				flow.setHolidayStartTime(startTime.replace("-",""));
  			}
  			if(StringUtils.isNotBlank(endTime)){
  				flow.setHolidayEndTime(endTime.replace("-",""));
  			}
  			flow.setFlowStatus("0"); //待审核
  			flow.setFlowType("1");  //请假申请
  			flow.setFlowName(FlowType.getValue(flow.getFlowType()));
  			HttpSession session = request.getSession();
  			String sessionId = session.getId();
  			TbUser user= JSONObject.parseObject(JeditCommon.get(sessionId), TbUser.class);
  			flow.setUserId(user.getUserId());
  			flow.setCreateTime(DateUtil.getDateAndTime());
  			flow.setUpdateTime(DateUtil.getDateAndTime());
  			tbFlowMapper.insertSelective(flow);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}


	@Override
	public Map<String, Object> getFlowList(Map<String, String> map, HttpServletRequest request) {
		String pageNum = map.get("pageNum");
		String pageSize = map.get("pageSize");
		String rangeTime = map.get("rangeTime");
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		TbUser user= JSONObject.parseObject(JeditCommon.get(sessionId), TbUser.class);
		Integer userId=user.getUserId();
		map.put("userId", userId.toString());
		
		if(StringUtils.isNotBlank(rangeTime)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -Integer.parseInt(rangeTime));
			String beforeDate=sdf.format(calendar.getTime());
			map.put("beforeDate", beforeDate);
		}
		
		//添加查询条件
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
  		List<Map> list = tbFlowMapperCust.getFlowList(map);
  		for(Map<String, String> l:list){
  			String flowStatus = l.get("flowStatus");
  			if(StringUtils.isNotBlank(flowStatus)){
  				l.put("flowStatus", FlowStatus.getValue(flowStatus));
  			}
  		}
		PageInfo<Map> pageInfo = new PageInfo<>(list);
  		return baseResult.getSuccMap(pageInfo);
	}
	
}
