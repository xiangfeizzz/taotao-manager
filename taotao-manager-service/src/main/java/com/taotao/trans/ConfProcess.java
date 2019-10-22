package com.taotao.trans;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbFlowConfMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowCheck;
import com.taotao.pojo.TbFlowConf;
import com.taotao.pojo.TbFlowConfExample;
import com.taotao.pojo.TbUser;

@Service
public class ConfProcess {

	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbFlowConfMapper tbFlowConfMapper;
	
	
	public String addProcess(TbFlow flow,TbFlowCheck check) {
		String returnMsg="";
		
		Integer userId = flow.getUserId();
		TbUser user = tbUserMapper.selectByPrimaryKey(userId);
		
		TbFlowConfExample example = new TbFlowConfExample();
		com.taotao.pojo.TbFlowConfExample.Criteria criteria = example.createCriteria();
  		criteria.andDeptIdEqualTo(user.getDeptId());
  		criteria.andPositionIdEqualTo(user.getPositionId());
  		criteria.andFlowTypeEqualTo(flow.getFlowType());
  		criteria.andUserIdEqualTo(flow.getUserId());
  		
  		
		List<TbFlowConf> list = tbFlowConfMapper.selectByExample(example);
		if(list==null || list.size()==0){  //如果没有配置特殊用户，查询该部门，该职务的流程
			TbFlowConfExample example2 = new TbFlowConfExample();
			com.taotao.pojo.TbFlowConfExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andDeptIdEqualTo(user.getDeptId());
			criteria2.andPositionIdEqualTo(user.getPositionId());
			criteria2.andFlowTypeEqualTo(flow.getFlowType());
			criteria2.andUserIdEqualTo(-1);
			list = tbFlowConfMapper.selectByExample(example2);
			if(list==null || list.size()==0){
				returnMsg="审批流程没配置";
				return returnMsg;
			}
		}
		
		TbFlowConf conf =list.get(0);
		
		String userIdOrder = conf.getUserIdOrder();
		if(StringUtils.isBlank(userIdOrder)){
			returnMsg="审核人没配置";
			return returnMsg;
		}
		
		String[] userIdArray = userIdOrder.split(",");
		
		check.setFlowId(flow.getFlowId());
		check.setConfId(conf.getConfId());
			
		String id=userIdArray[check.getIndexOf()];
		check.setUserId(Integer.parseInt(id));
		TbUser user2 = tbUserMapper.selectByPrimaryKey(check.getUserId());
		check.setUserName(user2.getUserName());
		check.setStatus("1"); //1待审核 3审核通过 4审核拒绝
		
		check.setCreateTime(DateUtil.getDateAndTime());
		check.setUpdateTime(DateUtil.getDateAndTime());
		return returnMsg;
		
	}

}
