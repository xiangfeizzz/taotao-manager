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
	
	
	public String process(TbFlow flow,TbFlowCheck check) {
		String returnMsg="";
		
		Integer userId = flow.getUserId();
		TbUser user = tbUserMapper.selectByPrimaryKey(userId);
		
		TbFlowConfExample example = new TbFlowConfExample();
		com.taotao.pojo.TbFlowConfExample.Criteria criteria = example.createCriteria();
  		criteria.andDeptIdEqualTo(user.getDeptId());
  		criteria.andPositionIdEqualTo(user.getPositionId());
  		criteria.andFlowTypeEqualTo(flow.getFlowType());
  		
  		if(flow.getUserId()==null){
  			criteria.andUserIdEqualTo(-1); //数据库中默认是1
  		}else{
  			criteria.andUserIdEqualTo(flow.getUserId());
  		}
		List<TbFlowConf> list = tbFlowConfMapper.selectByExample(example);
		if(list==null || list.size()==0){
			returnMsg="审批流程没配置";
			return returnMsg;
		}
		
		TbFlowConf conf = list.get(0);
		String userIdOrder = conf.getUserIdOrder();
		if(StringUtils.isBlank(userIdOrder)){
			returnMsg="审核人没配置";
			return returnMsg;
		}
		
		String[] userIdArray = userIdOrder.split(",");
		
		check.setFlowId(flow.getFlowId());
		check.setIndexOf(0);
		String id=userIdArray[check.getIndexOf()];
		check.setUserId(Integer.parseInt(id));
		check.setStatus("1"); //1待审核 3审核通过 4审核拒绝
		TbUser u = tbUserMapper.selectByPrimaryKey(Integer.parseInt(id));
		StringBuffer sb=new StringBuffer();
		sb.append("待 ").append(u.getUserName()).append(" 审核");
		check.setFlowDesc(sb.toString());
		
		check.setCreateTime(DateUtil.getDateAndTime());
		check.setUpdateTime(DateUtil.getDateAndTime());
		
		
		return returnMsg;
		
	}

}
