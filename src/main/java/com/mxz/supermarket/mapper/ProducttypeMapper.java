package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Producttype;
import com.mxz.supermarket.model.ProducttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProducttypeMapper {

    int countByExample(ProducttypeExample example);

    int deleteByExample(ProducttypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(Producttype record);

    int insertSelective(Producttype record);

    List<Producttype> selectByExample(ProducttypeExample example);

    Producttype selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") Producttype record, @Param("example") ProducttypeExample example);

    int updateByExample(@Param("record") Producttype record, @Param("example") ProducttypeExample example);

    int updateByPrimaryKeySelective(Producttype record);

    int updateByPrimaryKey(Producttype record);
}