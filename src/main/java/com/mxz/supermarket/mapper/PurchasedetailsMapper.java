package com.mxz.supermarket.mapper;

import com.mxz.supermarket.model.Purchasedetails;
import com.mxz.supermarket.model.PurchasedetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PurchasedetailsMapper {

    int countByExample(PurchasedetailsExample example);

    int deleteByExample(PurchasedetailsExample example);

    int deleteByPrimaryKey(Integer detailsId);

    int insert(Purchasedetails record);

    int insertSelective(Purchasedetails record);

    List<Purchasedetails> selectByExample(PurchasedetailsExample example);

    Purchasedetails selectByPrimaryKey(Integer detailsId);

    int updateByExampleSelective(@Param("record") Purchasedetails record, @Param("example") PurchasedetailsExample example);

    int updateByExample(@Param("record") Purchasedetails record, @Param("example") PurchasedetailsExample example);

    int updateByPrimaryKeySelective(Purchasedetails record);

    int updateByPrimaryKey(Purchasedetails record);
}