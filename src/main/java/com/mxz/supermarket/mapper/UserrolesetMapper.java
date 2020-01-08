package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Userroleset;
import com.mxz.supermarket.model.UserrolesetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserrolesetMapper {

    int countByExample(UserrolesetExample example);

    int deleteByExample(UserrolesetExample example);

    int insert(Userroleset record);

    int insertSelective(Userroleset record);

    List<Userroleset> selectByExample(UserrolesetExample example);

    int updateByExampleSelective(@Param("record") Userroleset record, @Param("example") UserrolesetExample example);

    int updateByExample(@Param("record") Userroleset record, @Param("example") UserrolesetExample example);
}