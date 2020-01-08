package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Right;
import com.mxz.supermarket.model.RightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightMapper {

    int countByExample(RightExample example);

    int deleteByExample(RightExample example);

    int deleteByPrimaryKey(Integer rightId);

    int insert(Right record);

    int insertSelective(Right record);

    List<Right> selectByExample(RightExample example);

    Right selectByPrimaryKey(Integer rightId);

    int updateByExampleSelective(@Param("record") Right record, @Param("example") RightExample example);

    int updateByExample(@Param("record") Right record, @Param("example") RightExample example);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
}