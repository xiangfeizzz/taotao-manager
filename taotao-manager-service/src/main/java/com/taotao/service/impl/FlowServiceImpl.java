package com.taotao.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.enums.FlowStatus;
import com.taotao.common.enums.FlowType;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.redis.JeditCommon;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbDeptMapper;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.mapper.TbPositionMapper;
import com.taotao.mapper.TbRoleMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbFlowConfMapperCust;
import com.taotao.mapperCust.TbFlowMapperCust;
import com.taotao.pojo.TbDept;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowCheck;
import com.taotao.pojo.TbPosition;
import com.taotao.pojo.TbRole;
import com.taotao.pojo.TbUser;
import com.taotao.service.FlowService;
import com.taotao.trans.CommonTrans;
import com.taotao.trans.ConfProcess;

@Service
public class FlowServiceImpl implements FlowService {

	@Autowired
	TbFlowMapper tbFlowMapper;
	@Autowired
	TbFlowMapperCust tbFlowMapperCust;
	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbDeptMapper tbDeptMapper;
	@Autowired
	TbRoleMapper tbRoleMapper;
	@Autowired
	TbPositionMapper tbPositionMapper;
	@Autowired
	ConfProcess confProcess;
	@Autowired
	CommonTrans commonTrans;
	
	BaseResult baseResult = new BaseResult();
	
	@Override
	public Map<String, Object> getFlowInfo(Map<String, String> map, HttpServletRequest request) {
		try {
			String flowId = map.get("flowId");
			TbFlow flow = tbFlowMapper.selectByPrimaryKey(Integer.parseInt(flowId));
			String holidayStartTime = flow.getHolidayStartTime();
			if(StringUtils.isNotBlank(holidayStartTime)){
				holidayStartTime=holidayStartTime.substring(0, 8);
  				flow.setHolidayStartTime(DateUtil.getDateFormatStr(holidayStartTime));
  			}
			String holidayEndTime = flow.getHolidayEndTime();
  			if(StringUtils.isNotBlank(holidayEndTime)){
  				holidayEndTime=holidayEndTime.substring(0,8);
  				flow.setHolidayEndTime(DateUtil.getDateFormatStr(holidayEndTime));
  			}
  			
  			String workextStartTime = flow.getWorkextStartTime();
  			if(StringUtils.isNotBlank(workextStartTime)){
  				workextStartTime=workextStartTime.substring(0, 8);
  				flow.setWorkextStartTime(DateUtil.getDateFormatStr(workextStartTime));
  			}
			String workextEndTime = flow.getWorkextEndTime();
  			if(StringUtils.isNotBlank(workextEndTime)){
  				workextEndTime=workextEndTime.substring(0,8);
  				flow.setWorkextEndTime(DateUtil.getDateFormatStr(workextEndTime));
  			}
			
			Integer userId = flow.getUserId();
			TbUser user = tbUserMapper.selectByPrimaryKey(userId);
			
			TbDept dept = tbDeptMapper.selectByPrimaryKey(user.getDeptId());
			TbPosition position = tbPositionMapper.selectByPrimaryKey(user.getPositionId());
			TbRole role = tbRoleMapper.selectByPrimaryKey(user.getRoleId());
			
			
			Map<String,Object> m=new HashMap<String, Object>();
			m.put("tbUser", user);
			m.put("tbDept", dept);
			m.put("tbPosition", position);
			m.put("tbRole", role);
			m.put("tbFlow", flow);
			return baseResult.getSuccMap(m);
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
		String type=request.getParameter("type");
		
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
		List<Map> list=new ArrayList<Map>();
		if("check".equals(type)){  //查询待我审批
			list=tbFlowMapperCust.getFlowListCheck(map);
		}else{ //查询自己申请的
			list = tbFlowMapperCust.getFlowList(map);
		}
		
  		for(Map<String, String> l:list){
  			String flowStatus = l.get("flowStatus");
  			if(StringUtils.isNotBlank(flowStatus)){
  				l.put("flowStatus", FlowStatus.getValue(flowStatus));
  			}
  		}
		PageInfo<Map> pageInfo = new PageInfo<>(list);
  		return baseResult.getSuccMap(pageInfo);
	}

	
	@Override
	public Map<String, Object> holidayAdd(Map<String, String> map ,HttpServletRequest request) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
  			flow.setFlowType("1");  //请假申请
  			flow.setFlowName(FlowType.getValue(flow.getFlowType()));
  			HttpSession session = request.getSession();
  			String sessionId = session.getId();
  			TbUser user= JSONObject.parseObject(JeditCommon.get(sessionId), TbUser.class);
  			flow.setUserId(user.getUserId());
  			flow.setCreateTime(DateUtil.getDateAndTime());
  			flow.setUpdateTime(DateUtil.getDateAndTime());
  			
  			String maxId = tbFlowMapperCust.getMaxId();
  			flow.setFlowId(Integer.parseInt(maxId));
  			
  			TbFlowCheck check=new TbFlowCheck();
  			String flowStatus = flow.getFlowStatus();
  			if("1".equals(flowStatus)){  //提交 待审核状态
  	  			String errorMsg=confProcess.process(flow,check);   //添加流程配置
  				if(StringUtils.isNotBlank(errorMsg)){
  					return baseResult.getErrorJsonObj(errorMsg);
  				}
  			}
  			
  			commonTrans.flowAdd(flow,check);
  			
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	

	@Override
	public Map<String, Object> workextAdd(Map<String, String> map, HttpServletRequest request) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbFlow flow = objectMapper.convertValue(map, TbFlow.class);
			flow.setCreateTime(DateUtil.getDateAndTime());
			String startTime = flow.getWorkextStartTime();
			String endTime = flow.getWorkextEndTime();
  			if(StringUtils.isNotBlank(startTime)){
  				flow.setWorkextStartTime(startTime.replace("-",""));
  			}
  			if(StringUtils.isNotBlank(endTime)){
  				flow.setWorkextEndTime(endTime.replace("-",""));
  			}
  			flow.setFlowType("2");  //加班申请
  			flow.setFlowName(FlowType.getValue(flow.getFlowType()));
  			HttpSession session = request.getSession();
  			String sessionId = session.getId();
  			TbUser user= JSONObject.parseObject(JeditCommon.get(sessionId), TbUser.class);
  			flow.setUserId(user.getUserId());
  			flow.setCreateTime(DateUtil.getDateAndTime());
  			flow.setUpdateTime(DateUtil.getDateAndTime());
  			
  			String maxId = tbFlowMapperCust.getMaxId();
  			flow.setFlowId(Integer.parseInt(maxId));
  			
  			TbFlowCheck check=new TbFlowCheck();
  			String flowStatus = flow.getFlowStatus();
  			if("1".equals(flowStatus)){  //提交 待审核状态
  	  			String errorMsg=confProcess.process(flow,check);   //添加流程配置
  				if(StringUtils.isNotBlank(errorMsg)){
  					return baseResult.getErrorJsonObj(errorMsg);
  				}
  			}
  			
  			commonTrans.flowAdd(flow,check);
  			
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	
}
