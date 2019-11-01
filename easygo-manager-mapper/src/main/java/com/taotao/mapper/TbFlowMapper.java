package com.taotao.mapper;

import com.taotao.pojo.TbFlow;
import com.taotao.pojo.TbFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFlowMapper {
    int countByExample(TbFlowExample example);

    int deleteByExample(TbFlowExample example);

    int deleteByPrimaryKey(Integer flowId);

    int insert(TbFlow record);

    int insertSelective(TbFlow record);

    List<TbFlow> selectByExample(TbFlowExample example);

    TbFlow selectByPrimaryKey(Integer flowId);

    int updateByExampleSelective(@Param("record") TbFlow record, @Param("example") TbFlowExample example);

    int updateByExample(@Param("record") TbFlow record, @Param("example") TbFlowExample example);

    int updateByPrimaryKeySelective(TbFlow record);

    int updateByPrimaryKey(TbFlow record);
}