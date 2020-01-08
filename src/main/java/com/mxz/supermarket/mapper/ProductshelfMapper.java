package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Productshelf;
import com.mxz.supermarket.model.ProductshelfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductshelfMapper {

    int countByExample(ProductshelfExample example);

    int deleteByExample(ProductshelfExample example);

    int deleteByPrimaryKey(Integer shelfId);

    int insert(Productshelf record);

    int insertSelective(Productshelf record);

    List<Productshelf> selectByExample(ProductshelfExample example);

    Productshelf selectByPrimaryKey(Integer shelfId);

    int updateByExampleSelective(@Param("record") Productshelf record, @Param("example") ProductshelfExample example);

    int updateByExample(@Param("record") Productshelf record, @Param("example") ProductshelfExample example);

    int updateByPrimaryKeySelective(Productshelf record);

    int updateByPrimaryKey(Productshelf record);
}