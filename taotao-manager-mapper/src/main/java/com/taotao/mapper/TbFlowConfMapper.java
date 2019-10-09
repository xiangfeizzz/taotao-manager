package com.taotao.mapper;

import com.taotao.pojo.TbFlowConf;
import com.taotao.pojo.TbFlowConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFlowConfMapper {
    int countByExample(TbFlowConfExample example);

    int deleteByExample(TbFlowConfExample example);

    int deleteByPrimaryKey(Integer confId);

    int insert(TbFlowConf record);

    int insertSelective(TbFlowConf record);

    List<TbFlowConf> selectByExample(TbFlowConfExample example);

    TbFlowConf selectByPrimaryKey(Integer confId);

    int updateByExampleSelective(@Param("record") TbFlowConf record, @Param("example") TbFlowConfExample example);

    int updateByExample(@Param("record") TbFlowConf record, @Param("example") TbFlowConfExample example);

    int updateByPrimaryKeySelective(TbFlowConf record);

    int updateByPrimaryKey(TbFlowConf record);
}