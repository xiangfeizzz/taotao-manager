package com.taotao.mapperCust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.taotao.pojo.TbMenu;

public interface TbFlowMapperCust {

	List<TbMenu> selectByRoleId(@Param("loginName") String loginName, @Param("grade") String grade);

	List<Map> getFlowList(Map<String, String> map);


}