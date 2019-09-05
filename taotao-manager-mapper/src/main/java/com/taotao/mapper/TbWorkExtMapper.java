package com.taotao.mapper;

import com.taotao.pojo.TbWorkExt;
import com.taotao.pojo.TbWorkExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbWorkExtMapper {
    int countByExample(TbWorkExtExample example);

    int deleteByExample(TbWorkExtExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbWorkExt record);

    int insertSelective(TbWorkExt record);

    List<TbWorkExt> selectByExample(TbWorkExtExample example);

    TbWorkExt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbWorkExt record, @Param("example") TbWorkExtExample example);

    int updateByExample(@Param("record") TbWorkExt record, @Param("example") TbWorkExtExample example);

    int updateByPrimaryKeySelective(TbWorkExt record);

    int updateByPrimaryKey(TbWorkExt record);
}