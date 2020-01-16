package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.SupermarketApplication;
import com.mxz.supermarket.model.Orders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 向清润
 * @createTime 2020.01.10.15:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketApplication.class)
class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;

//    @Test
//    void addOrder() {
//
//        Orders orders = new Orders("12323231",new Date(),1,23,"农夫山泉","饮料");
//
//        boolean b = orderService.addOrder(orders);
//        System.out.println(b);
//    }

//    @Test
//    void addBatchOrders() {
//
//        List<Orders> orders = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Orders order = new Orders("12323231"+i,new Date(),1,23,"农夫山泉"+i,"饮料");
//
//            orders.add(order);
//        }
//        boolean b = orderService.addBatchOrders(orders);
//
//
//    }

    @Test
    void deleteOrder() {
        boolean b = orderService.deleteOrder(1);
        System.out.println(b);
    }

    @Test
    void paymentOrder() {
        boolean b = orderService.paymentOrder(1, 0);
        System.out.println(b);
    }

    @Test
    void selectOrders() {
        PageInfo<Orders> ordersPageInfo = orderService.selectOrders(1, 5);
        for (int i = 0; i < 1; i++) {
            System.out.println(ordersPageInfo.getList().get(i));
        }

    }

    @Test
    void selectOneOrder() {
        Orders orders = orderService.selectOneOrder(1);
        System.out.println(orders);
    }

    @Test
    void seletcOrdersByType() {

        PageInfo<Orders> info = orderService.seletcOrdersByType("饮料", 1, 5);
        for (Orders orders:
             info.getList()) {
            System.out.println(orders);
        }
    }

    @Test
    void selectOrdersByName() {
        PageInfo<Orders> info = orderService.selectOrdersByName("农夫山泉", 1, 5);
        for (Orders orders:
                info.getList()) {
            System.out.println(orders);
        }
    }
}