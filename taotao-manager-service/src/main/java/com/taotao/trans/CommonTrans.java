package com.taotao.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taotao.mapper.TbFlowCheckMapper;
import com.taotao.mapper.TbFlowMapper;
import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowCheck;

@Service
@Transactional
public class CommonTrans {

	@Autowired
	TbFlowMapper tbFlowMapper;
	@Autowired
	TbFlowCheckMapper tbFlowCheckMapper;
	


	public void flowAdd(TbFlow flow, TbFlowCheck check) {
		try {
			if(flow.getFlowId()!=null){
				tbFlowMapper.insertSelective(flow);
			}
			if(check.getFlowId()!=null){
				tbFlowCheckMapper.insertSelective(check);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
