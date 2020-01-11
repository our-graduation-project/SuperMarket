package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.mapper.StoreMapper;
import com.mxz.supermarket.model.Store;
import com.mxz.supermarket.model.StoreExample;
import com.mxz.supermarket.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper mapper;

    /**
     * 增加库存信息
     * @param store
     * @return
     */
    @Override
    public int addStore(Store store) {
        return mapper.insert(store);
    }

    /**
     * 修改库存信息
     * @param store
     * @return
     */
    @Override
    public boolean updateStore(Store store) {
        int i = mapper.updateByPrimaryKeySelective(store);
        return i>0 ?true :false;
    }

    /**
     * 根据ID查询库存信息
     * @param storeId
     * @return
     */
    @Override
    public Store searchStoreByStoreId(Integer storeId) {
        Store store = mapper.selectByPrimaryKey(storeId);
        return store;
    }

    /**
     * 根据名称查询库存信息
     * @param page
     * @param limit
     * @param storeName
     * @return
     */
    @Override
    public PageInfo<Store> searchStoreBystoreName(int page, int limit, String storeName) {
        StoreExample example=new StoreExample();
        example.or().andStoreNameEqualTo(storeName);
        PageHelper.startPage(page, limit);
        List<Store> stores = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(stores,3);
        return pageInfo;
    }

    /**
     * 查询所有库存信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Store> searchStores(int page, int limit) {
        StoreExample example=new StoreExample();
        example.or();
        PageHelper.startPage(page, limit);
        List<Store> stores = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(stores,3);
        return pageInfo;
    }

    /**
     * 根据入库时间查询库存
     * @param page
     * @param limit
     * @param instoreTime
     * @param order
     * @param orderEnum
     * @return
     */
    @Override
    public PageInfo<Store> searchStoreByTime(int page, int limit, Date instoreTime, String order, OrderEnum orderEnum) {
        StoreExample example=new StoreExample();
        example.or().andInstoreTimeEqualTo(instoreTime);
        if (order != null) {
            String str = null;
            str = "`" + order + "` ";
            if (orderEnum != null) {

                str += orderEnum.getName();
            } else {
                str += OrderEnum.DESC.getName();
            }
            example.setOrderByClause(str);
        }
        PageHelper.startPage(page,limit);
        List<Store> stores = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(stores,3);
        return pageInfo;
    }

    /**
     * 根据ID删除
     * @param storeId
     * @return
     */
    @Override
    public boolean deleteStore(Integer storeId) {
        int i = mapper.deleteByPrimaryKey(storeId);
        return i>0?true:false;
    }
}
