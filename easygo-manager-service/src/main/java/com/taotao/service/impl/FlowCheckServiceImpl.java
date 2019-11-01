package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.enums.FlowStatus;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbFlowCheckMapper;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowCheck;
import com.taotao.pojo.TbFlowCheckExample;
import com.taotao.pojo.TbFlowConf;
import com.taotao.pojo.TbUser;
import com.taotao.service.FlowCheckService;

@Service
public class FlowCheckServiceImpl implements FlowCheckService {

	@Autowired
	TbFlowCheckMapper tbFlowCheckMapper;
	@Autowired
	TbFlowConfMapper tbFlowConfMapper;
	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbFlowMapper tbFlowMapper;
	
	
	BaseResult baseResult = new BaseResult();

	@Override
	public Map<String, Object> add(Map<String, String> map,HttpServletRequest request) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbFlowCheck c = objectMapper.convertValue(map, TbFlowCheck.class);
			if(c.getCheckId()==null){
				return baseResult.getErrorMap("checkId不能为空");
			}
			if(StringUtils.isBlank(c.getStatus())){
				return baseResult.getErrorMap("审核状态不能为空");
			}
			if(StringUtils.isBlank(c.getCheckDesc())){
				return baseResult.getErrorMap("审核意见不能为空");
			}
			
	  		
			TbFlowCheck check = tbFlowCheckMapper.selectByPrimaryKey(c.getCheckId());
			if(!FlowStatus.flowStatus_1.getCode().equals(check.getStatus())){
				return baseResult.getErrorMap("待审核状态才能审核");
			}
			
			Integer indexOf = check.getIndexOf();
			TbFlow flow = tbFlowMapper.selectByPrimaryKey(check.getFlowId());
			
			
			String status = c.getStatus();
			String checkDesc=c.getCheckDesc();
			if("3".equals(status)){  //审核通过
				TbFlowConf conf = tbFlowConfMapper.selectByPrimaryKey(check.getConfId());
				String userIdOrder = conf.getUserIdOrder();
				String[] split = userIdOrder.split(",");
				int length = split.length;
				indexOf++;
				if(indexOf<length){
					flow.setFlowStatus("2");  //审核中
					String id = split[indexOf];
					TbFlowCheck checkNew=new TbFlowCheck();
					checkNew.setFlowId(check.getFlowId());
					checkNew.setConfId(check.getConfId());
					checkNew.setUserId(Integer.parseInt(id));
					checkNew.setStatus("1"); //1待审核 3审核通过 4审核拒绝
					checkNew.setIndexOf(indexOf);
					checkNew.setCreateTime(DateUtil.getDateAndTime());
					checkNew.setUpdateTime(DateUtil.getDateAndTime());
					tbFlowCheckMapper.insertSelective(checkNew);
					
				}else if(indexOf==length){  //到最后一个节点
					flow.setFlowStatus("5");  //审核完成
				}else{
					return baseResult.getErrorMap("系统异常");
				}
				
				tbFlowMapper.updateByPrimaryKey(flow);
				check.setStatus("3");
				check.setCheckDesc(checkDesc);
				check.setUpdateTime(DateUtil.getDateAndTime());
				tbFlowCheckMapper.updateByPrimaryKey(check);
			}
			if("4".equals(status)){
				flow.setFlowStatus("4");  //审核拒绝
				tbFlowMapper.updateByPrimaryKey(flow);
				
				check.setStatus("4");
				check.setCheckDesc(checkDesc);
				check.setUpdateTime(DateUtil.getDateAndTime());
				tbFlowCheckMapper.updateByPrimaryKey(check);
			}
			
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}

	@Override
	public Map<String, Object> list(Map<String, String> map, HttpServletRequest request) {
		String flowId=map.get("flowId");
		
		TbFlowCheckExample example = new TbFlowCheckExample();
		com.taotao.pojo.TbFlowCheckExample.Criteria criteria = example.createCriteria();
  		criteria.andFlowIdEqualTo(Integer.parseInt(flowId));
  		example.setOrderByClause(" create_time desc ");
  		List<TbFlowCheck> list = tbFlowCheckMapper.selectByExample(example);
  		
  		for(TbFlowCheck c:list){
  			c.setStatus(FlowStatus.getValue(c.getStatus()));
  		}
  		
		return baseResult.getSuccMap(list);
		
		
	}
	
}
