package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Rolerightset;
import com.mxz.supermarket.model.RolerightsetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolerightsetMapper {

    int countByExample(RolerightsetExample example);

    int deleteByExample(RolerightsetExample example);

    int insert(Rolerightset record);

    int insertSelective(Rolerightset record);

    List<Rolerightset> selectByExample(RolerightsetExample example);

    int updateByExampleSelective(@Param("record") Rolerightset record, @Param("example") RolerightsetExample example);

    int updateByExample(@Param("record") Rolerightset record, @Param("example") RolerightsetExample example);
}