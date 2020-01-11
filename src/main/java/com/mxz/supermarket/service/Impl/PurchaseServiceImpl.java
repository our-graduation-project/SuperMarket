package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.mapper.PurchaseMapper;
import com.mxz.supermarket.model.Purchase;
import com.mxz.supermarket.model.PurchaseExample;
import com.mxz.supermarket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper mapper;
    /**
     * 增加进货单信息
     * @param purchase
     * @return
     */
    @Override
    public int addPurchase(Purchase purchase) {
        return mapper.insert(purchase);
    }

    /**
     * 修改供货商信息
     * @param purchase
     * @return
     */
    @Override
    public boolean updateStore(Purchase purchase) {
        int i = mapper.updateByPrimaryKeySelective(purchase);
        return i>0?true:false;
    }

    /**
     * 根据ID查询进货单信息
     * @param purchaseId
     * @return
     */
    @Override
    public Purchase searchPurchaseByPurchaseId(Integer purchaseId) {
        Purchase purchase = mapper.selectByPrimaryKey(purchaseId);
        return purchase;
    }

    /**
     * 根据name查询进货单信息
     * @param purchaseNo
     * @return
     */
    @Override
    public PageInfo<Purchase> searchPurchaseBypurchaseNo(int page, int limit, String purchaseNo) {
        PurchaseExample example=new PurchaseExample();
        example.or().andPurchaseNoEqualTo(purchaseNo);
        PageHelper.startPage(page, limit);
        List<Purchase> purchases = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(purchases,3);
        return pageInfo;
    }

    /**
     * 查询所有进货单信息
     * @param
     * @return
     */
    @Override
    public PageInfo<Purchase> searchPurchases(int page, int limit) {
        PurchaseExample example=new PurchaseExample();
        example.or();
        PageHelper.startPage(page, limit);
        List<Purchase> purchases = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(purchases,3);
        return pageInfo;
    }

    /**
     * 根据进货时间查询进货单信息
     * @param page
     * @param limit
     * @param purchaseTime
     * @param order
     * @param orderEnum
     * @return
     */
    @Override
    public PageInfo<Purchase> searchPurchaseByTime(int page, int limit, Date purchaseTime, String order, OrderEnum orderEnum) {
        PurchaseExample example=new PurchaseExample();
        example.or().andPurchaseTimeEqualTo(purchaseTime);
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
        List<Purchase> purchases = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(purchases,3);
        return pageInfo;
    }
}
