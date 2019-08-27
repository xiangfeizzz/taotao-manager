package com.taotao.mapper;

import com.taotao.pojo.TbRoleMenu;
import com.taotao.pojo.TbRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoleMenuMapper {
    int countByExample(TbRoleMenuExample example);

    int deleteByExample(TbRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbRoleMenu record);

    int insertSelective(TbRoleMenu record);

    List<TbRoleMenu> selectByExample(TbRoleMenuExample example);

    TbRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbRoleMenu record, @Param("example") TbRoleMenuExample example);

    int updateByExample(@Param("record") TbRoleMenu record, @Param("example") TbRoleMenuExample example);

    int updateByPrimaryKeySelective(TbRoleMenu record);

    int updateByPrimaryKey(TbRoleMenu record);
}