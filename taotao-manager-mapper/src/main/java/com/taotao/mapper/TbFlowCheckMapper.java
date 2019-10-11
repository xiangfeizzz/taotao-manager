package com.taotao.mapper;

import com.taotao.pojo.TbFlowCheck;
import com.taotao.pojo.TbFlowCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFlowCheckMapper {
    int countByExample(TbFlowCheckExample example);

    int deleteByExample(TbFlowCheckExample example);

    int deleteByPrimaryKey(Integer checkId);

    int insert(TbFlowCheck record);

    int insertSelective(TbFlowCheck record);

    List<TbFlowCheck> selectByExample(TbFlowCheckExample example);

    TbFlowCheck selectByPrimaryKey(Integer checkId);

    int updateByExampleSelective(@Param("record") TbFlowCheck record, @Param("example") TbFlowCheckExample example);

    int updateByExample(@Param("record") TbFlowCheck record, @Param("example") TbFlowCheckExample example);

    int updateByPrimaryKeySelective(TbFlowCheck record);

    int updateByPrimaryKey(TbFlowCheck record);
}