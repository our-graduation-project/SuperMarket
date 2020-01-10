package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.OrdersMapper;
import com.mxz.supermarket.model.Orders;
import com.mxz.supermarket.model.OrdersExample;
import com.mxz.supermarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 向清润
 * @createTime 2020.01.10.9:12
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Resource(type = OrdersMapper.class)
    OrdersMapper ordersMapper;



    /**
     * 增加订单
     *
     * @param orders 订单数据
     * @return 是否成功
     */
    @Override
    public boolean addOrder(Orders orders) {
        int insert = ordersMapper.insert(orders);
        if(insert == 1){
            return true;
        }

        return false;
    }

    /**
     * 批量增加订单
     *
     * @param orders 订单列表
     * @return 是否增加成功
     */
    @Override
    public boolean addBatchOrders(List<Orders> orders) {
        int i = ordersMapper.addBatchOrders(orders);
        if(i==orders.size()){
            return true;
        }
        return false;
    }

    /**
     * 根据id删除订单
     *
     * @param orderId 订单的id号
     * @return 是否删除成功
     */
    @Override
    public boolean deleteOrder(Integer orderId) {
        int i = ordersMapper.deleteByPrimaryKey(orderId);
        if(i==1){
            return true;
        }
        return false;
    }

    /**
     * 订单付款
     *
     * @param orderId 订单id
     * @param state 需要修改的状态
     * @return 是否修改付款状态成功
     */
    @Override
    public boolean paymentOrder(Integer orderId,Integer state) {

        Orders orders = new Orders();
        orders.setOrderStatus(state);
        orders.setOrderId(orderId);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if(i==1){
            return true;
        }
        return false;
    }

    /**
     * 分页查询所有订单
     *
     * @param page  当前页码
     * @param limit 页码大小
     * @return 查询出来的分页数据
     */
    @Override
    public PageInfo<Orders> selectOrders(int page, int limit) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.or();
        PageHelper.startPage(page,limit);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        PageInfo pageInfo = new PageInfo(orders,5);

        return pageInfo;
    }

    /**
     * 根据id查询订单
     *
     * @param orderId 订单id
     * @return 订单数据
     */
    @Override
    public Orders selectOneOrder(Integer orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        return orders;
    }

    /**
     * 根据商品类别分页查询订单
     *
     * @param typeName 商品类别
     * @param page     当前页码
     * @param limit    页面大小
     * @return 分页查询出来的商品数据
     */
    @Override
    public PageInfo<Orders> seletcOrdersByType(String typeName, int page, int limit) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.or().andTypeNameEqualTo(typeName);
        PageHelper.startPage(page,limit);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        PageInfo pageInfo = new PageInfo(orders,5);

        return pageInfo;
    }

    /**
     * 根据商品名分页查询订单
     *
     * @param name  商品名称
     * @param page  当前页码
     * @param limit 页面大小
     * @return 分页查询出来的商品数据
     */
    @Override
    public PageInfo<Orders> selectOrdersByName(String name, int page, int limit) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.or().andProductNameEqualTo(name);
        PageHelper.startPage(page,limit);
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        PageInfo pageInfo = new PageInfo(orders,5);

        return pageInfo;
    }
}
