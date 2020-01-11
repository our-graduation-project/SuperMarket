package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Orderdetails;
import com.mxz.supermarket.model.OrderdetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderdetailsMapper {

    int countByExample(OrderdetailsExample example);

    int deleteByExample(OrderdetailsExample example);

    int deleteByPrimaryKey(Integer detailsId);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    List<Orderdetails> selectByExample(OrderdetailsExample example);

    Orderdetails selectByPrimaryKey(Integer detailsId);

    int updateByExampleSelective(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByExample(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);
}