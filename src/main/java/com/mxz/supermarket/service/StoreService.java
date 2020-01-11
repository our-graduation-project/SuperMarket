package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.model.Store;

import java.util.Date;

public interface StoreService {

    /**
     * 增加库存信息
     * @param store
     * @return
     */
    int addStore(Store store);

    /**
     * 修改库存信息
     * @param store
     * @return
     */
    boolean updateStore(Store store);


    /**
     * 根据ID查询库存信息
     * @param storeId
     * @return
     */
    Store searchStoreByStoreId(Integer storeId);

    /**
     * 根据名字查询库存信息
     * @param storeName
     * @return
     */
    PageInfo<Store> searchStoreBystoreName(int page, int limit, String storeName);

    /**
     * 查询所有库存信息
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Store> searchStores(int page, int limit);

    /**
     * 根据入库时间查询
     * @param page
     * @param limit
     * @param instoreTime
     * @param order
     * @param orderEnum
     * @return
     */
    PageInfo<Store> searchStoreByTime(int page, int limit, Date instoreTime, String order, OrderEnum orderEnum);

    /**
     * 根据ID删除
     * @param storeId
     * @return
     */
    boolean deleteStore(Integer storeId);
}
