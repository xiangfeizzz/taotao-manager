package com.taotao.mapperCust;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.taotao.pojo.TbMenu;

public interface TbFlowConfMapperCust {

	List<Map> getFlowConfList(Map<String, String> map);


}