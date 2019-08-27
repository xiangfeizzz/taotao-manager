package com.taotao.mapper;

import com.taotao.pojo.TbDept;
import com.taotao.pojo.TbDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDeptMapper {
    int countByExample(TbDeptExample example);

    int deleteByExample(TbDeptExample example);

    int deleteByPrimaryKey(String deptId);

    int insert(TbDept record);

    int insertSelective(TbDept record);

    List<TbDept> selectByExample(TbDeptExample example);

    TbDept selectByPrimaryKey(String deptId);

    int updateByExampleSelective(@Param("record") TbDept record, @Param("example") TbDeptExample example);

    int updateByExample(@Param("record") TbDept record, @Param("example") TbDeptExample example);

    int updateByPrimaryKeySelective(TbDept record);

    int updateByPrimaryKey(TbDept record);
}