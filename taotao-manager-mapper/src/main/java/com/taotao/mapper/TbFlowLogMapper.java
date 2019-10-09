package com.taotao.mapper;

import com.taotao.pojo.TbFlowLog;
import com.taotao.pojo.TbFlowLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFlowLogMapper {
    int countByExample(TbFlowLogExample example);

    int deleteByExample(TbFlowLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFlowLog record);

    int insertSelective(TbFlowLog record);

    List<TbFlowLog> selectByExample(TbFlowLogExample example);

    TbFlowLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFlowLog record, @Param("example") TbFlowLogExample example);

    int updateByExample(@Param("record") TbFlowLog record, @Param("example") TbFlowLogExample example);

    int updateByPrimaryKeySelective(TbFlowLog record);

    int updateByPrimaryKey(TbFlowLog record);
}