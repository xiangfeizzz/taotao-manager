package com.taotao.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbFlowCheckMapper;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowCheck;
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
			String userId = check.getUserId().toString();
			Integer indexOf = check.getIndexOf();
			TbFlow flow = tbFlowMapper.selectByPrimaryKey(check.getFlowId());
			
			
			String status = c.getStatus();
			if("3".equals(status)){  //审核通过
				TbFlowConf conf = tbFlowConfMapper.selectByPrimaryKey(check.getConfId());
				String userIdOrder = conf.getUserIdOrder();
				String[] split = userIdOrder.split(",");
				int length = split.length;
				indexOf++;
				if(indexOf<length){
					flow.setFlowStatus("2");  //审核中
					String id = split[indexOf];
					TbFlowCheck checkNew=check;
					checkNew.setCheckId(null);
					checkNew.setIndexOf(indexOf);
					checkNew.setUserId(Integer.parseInt(id));
					checkNew.setStatus("1"); //1待审核 3审核通过 4审核拒绝
					TbUser u = tbUserMapper.selectByPrimaryKey(Integer.parseInt(id));
					StringBuffer sb=new StringBuffer();
					sb.append("待 ").append(u.getUserName()).append(" 审核");
					checkNew.setCheckDesc(sb.toString());
					checkNew.setCreateTime(DateUtil.getDateAndTime());
					checkNew.setUpdateTime(DateUtil.getDateAndTime());
					tbFlowCheckMapper.insertSelective(checkNew);
					
				}else if(indexOf==length){  //到最后一个节点
					flow.setFlowStatus("5");  //审核完成
				}else{
					return baseResult.getErrorMap("系统异常");
				}
				
				tbFlowMapper.updateByPrimaryKey(flow);
				
				TbUser u2 = tbUserMapper.selectByPrimaryKey(check.getUserId());
				StringBuffer s2=new StringBuffer();
				s2.append(u2.getUserName()).append(" 已经审核通过");
				check.setStatus("3");
				check.setCheckDesc(s2.toString());
				check.setUpdateTime(DateUtil.getDateAndTime());
				tbFlowCheckMapper.updateByPrimaryKey(check);
				
			}
			if("4".equals(status)){
				
			}
			
			
			if(check.getCheckId()==null){  //第一次新增
				
				
			}else{ //修改的
				
				
			}
			
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}

	
}
