package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Orders;

import java.util.List;

/**
 * @author 向清润
 * @createTime 2020.01.10.8:59
 */
public interface OrderService {


    /**
     * 增加订单
     * @param orders 订单数据
     * @return 是否成功
     */
    boolean addOrder(Orders orders);


    /**
     * 批量增加订单
     * @param orders 订单列表
     * @return 是否增加成功
     */
    boolean addBatchOrders(List<Orders> orders);


    /**
     * 根据id删除订单
    * @param orderId 订单的id号
     * @return 是否删除成功
     */
    boolean deleteOrder(Integer orderId);


    /**
     * 订单付款
     * @param orderId 订单id
     * @return 是否修改付款状态成功
     */
    boolean paymentOrder(Integer orderId,Integer state);


    /**
     * 分页查询所有订单
     * @param page 当前页码
     * @param limit 页码大小
     * @return 查询出来的分页数据
     */
    PageInfo<Orders> selectOrders(int page,int limit);


    /**
     * 根据id查询订单
     * @param orderId 订单id
     * @return 订单数据
     */
    Orders selectOneOrder(Integer orderId);


    /**
     * 根据商品类别分页查询订单
     * @param typeName 商品类别
     * @param page 当前页码
     * @param limit 页面大小
     * @return 分页查询出来的商品数据
     */
    PageInfo<Orders> seletcOrdersByType(String typeName,int page,int limit);


    /**
     * 根据商品名分页查询订单
     * @param name 商品名称
     * @param page 当前页码
     * @param limit 页面大小
     * @return 分页查询出来的商品数据
     */
    PageInfo<Orders> selectOrdersByName(String name,int page,int limit);


}
