package com.taotao.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;

@Service
public class Validate {

	@Autowired
	TbUserMapper tbUserMapper;
	
	public String validateUser(TbUser user) {
		String returnMsg = null;
		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(user.getLoginName());
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			returnMsg="登录名称已经存在";
		}
		return returnMsg;
	}


}
