package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.model.Purchase;

import java.util.Date;

public interface PurchaseService {
    /**
     * 增加进货单信息
     * @param purchase
     * @return
     */
    int addPurchase(Purchase purchase);

    /**
     * 修改进货单信息
     * @param purchase
     * @return
     */
    boolean updateStore(Purchase purchase);


    /**
     * 根据ID查询进货单信息
     * @param purchaseId
     * @return
     */
    Purchase searchPurchaseByPurchaseId(Integer purchaseId);

    /**
     * 根据编号查询进货单信息
     * @param purchaseNo
     * @return
     */
    PageInfo<Purchase> searchPurchaseBypurchaseNo(int page, int limit, String purchaseNo);

    /**
     * 查询所有进货单信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Purchase> searchPurchases(int page, int limit);

    /**
     * 根据进货时间查询
     * @param page
     * @param limit
     * @param purchaseTime
     * @param order
     * @param orderEnum
     * @return
     */
    PageInfo<Purchase> searchPurchaseByTime(int page, int limit, Date purchaseTime, String order, OrderEnum orderEnum);
}
