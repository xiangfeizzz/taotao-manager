package com.taotao.mapperCust;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taotao.pojo.TbMenu;

public interface TbMenuMapperCust {

	List<TbMenu> selectByRoleId(@Param("loginName") String loginName, @Param("grade") String grade);


}