package com.taotao.validate;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.enums.FlowStatus;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowConf;
import com.taotao.pojo.TbFlowConfExample;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;

@Service
public class Validate {

	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbFlowConfMapper tbFlowConfMapper;
	@Autowired
	TbFlowMapper tbFlowMapper;
	
	public String validateUser(TbUser user) {
		String returnMsg = null;
		TbUserExample example = new TbUserExample();
		com.taotao.pojo.TbUserExample.Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(user.getLoginName());
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			returnMsg="登录名称已经存在";
		}
		return returnMsg;
	}
	
	public String validateFlowConf(TbFlowConf conf) {
		String returnMsg = null;
		TbFlowConfExample example = new TbFlowConfExample();
		com.taotao.pojo.TbFlowConfExample.Criteria criteria = example.createCriteria();
  		criteria.andDeptIdEqualTo(conf.getDeptId());
  		criteria.andPositionIdEqualTo(conf.getPositionId());
  		criteria.andFlowTypeEqualTo(conf.getFlowType());
  		if(conf.getUserId()==null){
  			criteria.andUserIdEqualTo(-1); //数据库中默认是1
  		}else{
  			criteria.andUserIdEqualTo(conf.getUserId());
  		}
		List<TbFlowConf> list = tbFlowConfMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			returnMsg="该流程配置已经存在";
		}
		return returnMsg;
	}

	public String validateFlow(TbFlow f) {
		String returnMsg=null;
		Integer flowId = f.getFlowId();
		if(flowId==null){
			returnMsg="flowId不能为空";
		}
		TbFlow flow = tbFlowMapper.selectByPrimaryKey(flowId);
		if(flow!=null){
			if(!FlowStatus.flowStatus_0.getCode().equals(flow.getFlowStatus())
					&& !FlowStatus.flowStatus_4.getCode().equals(flow.getFlowStatus())){
				returnMsg="起草状态、审核拒绝状态才能修改";
			}
		}
		return returnMsg;
	}
}
