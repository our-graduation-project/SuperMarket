package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Producttype;

public interface ProducttypeService {

    /**
     * 增加商品类型
     * @param producttype
     * @return
     */
    int addProducttype(Producttype producttype);

    /**
     * 修改商品类型
     * @param producttype
     * @return
     */
    boolean updateProducttype(Producttype producttype);


    /**
     * 根据ID查询商品类型
     * @param typeId
     * @return
     */
    Producttype searchTypeByTypeId(Integer typeId);

    /**
     * 根据名字查询商品类型
     * @param typeName
     * @return
     */
    PageInfo<Producttype> searchTypeByTypeName(int page, int limit, String typeName);

    /**
     * 查询所有供货商
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Producttype> searchTypes(int page, int limit);

    /**
     * 根据ID删除供货商
     * @param typeId
     * @return
     */
    boolean deleteType(Integer typeId);
}
