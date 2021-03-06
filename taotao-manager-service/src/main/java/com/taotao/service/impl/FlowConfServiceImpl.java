package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.enums.FlowType;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbFlowConfMapperCust;
import com.taotao.pojo.TbDept;
import com.taotao.pojo.TbFlowConf;
import com.taotao.pojo.TbPosition;
import com.taotao.pojo.TbRole;
import com.taotao.pojo.TbUser;
import com.taotao.service.FlowConfService;
import com.taotao.validate.Validate;

@Service
public class FlowConfServiceImpl implements FlowConfService {

	@Autowired
	TbFlowConfMapper tbFlowConfMapper;
	@Autowired
	TbFlowConfMapperCust tbFlowConfMapperCust;
	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	Validate validate;
	
	BaseResult baseResult = new BaseResult();

	@Override
	public Map<String, Object> getFlowConfInfo(Map<String, String> map, HttpServletRequest request) {
		try {
		    String confId = map.get("confId").toString();
		    TbFlowConf conf = tbFlowConfMapper.selectByPrimaryKey(Integer.parseInt(confId));
	  		if (conf != null ) {
	  			Map<String,Object> m=new HashMap<String, Object>();
	  			Integer userId = conf.getUserId();
	  			TbUser u = tbUserMapper.selectByPrimaryKey(userId);
	  			if(u!=null){
	  				String userName = u.getUserName();
	  				m.put("userId", userId);
	  				m.put("userName", userName);
	  			}
	  			String userIdOrder = conf.getUserIdOrder();
	  			if(StringUtils.isNotBlank(userIdOrder)){
	  				StringBuffer userNameOrder=new StringBuffer();
	  				for(String id:userIdOrder.split(",")){
	  					TbUser user = tbUserMapper.selectByPrimaryKey(Integer.parseInt(id));
	  					userNameOrder.append(user.getUserName()).append(",");
	  				}
	  				m.put("userIdOrder", userIdOrder);
	  				m.put("userNameOrder", userNameOrder.deleteCharAt(userNameOrder.length()-1));
	  			}
	  			m.put("confId", conf.getConfId());
	  			m.put("deptId", conf.getDeptId());
	  			m.put("positionId", conf.getPositionId());
	  			m.put("flowType", conf.getFlowType());
	  			m.put("confDesc", conf.getConfDesc());
	  			m.put("createTime", conf.getCreateTime());
	  			m.put("updateTime", conf.getUpdateTime());
	  			Map<String,Object> returnMap=new HashMap<String, Object>();
	  			returnMap.put("tbFlowConf", m);
	  			return baseResult.getSuccMap(returnMap);
	  		}else{
	  			return baseResult.getErrorJsonObj("该流程不存在");
	  		}
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}

	@Override
	public Map<String, Object> getFlowConfList(Map<String, String> map, HttpServletRequest request) {
		String pageNum = map.get("pageNum");
		String pageSize = map.get("pageSize");
		//添加查询条件
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
		List<Map> list = tbFlowConfMapperCust.getFlowConfList(map);
  		for(Map<String, String> l:list){
  			String userIdOrder = l.get("userIdOrder");
  			if(StringUtils.isNotBlank(userIdOrder)){
  				String[] ids = userIdOrder.split(",");
  				StringBuffer sb=new StringBuffer();
  				for(String id:ids){
  					TbUser user = tbUserMapper.selectByPrimaryKey(Integer.parseInt(id));
  					sb.append(user.getUserName()).append(",");
  				}
  				l.put("userNameOrder",sb.deleteCharAt(sb.length()-1).toString());
  				l.put("flowName",FlowType.getValue(l.get("flowType")));
  			}
  		}
		PageInfo<Map> pageInfo = new PageInfo<>(list);
  		return baseResult.getSuccMap(pageInfo);
	}

	@Override
	public Map<String, Object> del(Map<String, String> map) {
		String confId = map.get("confId");
		tbFlowConfMapper.deleteByPrimaryKey(Integer.parseInt(confId));
		return baseResult.getSuccMap();
	}

	@Override
	public Map<String, Object> add(Map<String, String> map) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbFlowConf conf = objectMapper.convertValue(map, TbFlowConf.class);
			String errorMsg=validate.validateFlowConf(conf);
			if(StringUtils.isNotBlank(errorMsg)){
				return baseResult.getErrorJsonObj(errorMsg);
			}
			conf.setCreateTime(DateUtil.getDateAndTime());
			tbFlowConfMapper.insertSelective(conf);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}

	@Override
	public Map<String, Object> upd(Map<String, String> map) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbFlowConf conf = objectMapper.convertValue(map, TbFlowConf.class);
			String errorMsg=validate.validateFlowConf(conf);
			if(StringUtils.isNotBlank(errorMsg)){
				return baseResult.getErrorJsonObj(errorMsg);
			}
			conf.setUpdateTime(DateUtil.getDateAndTime());
			tbFlowConfMapper.updateByPrimaryKeySelective(conf);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	
	
	
}
