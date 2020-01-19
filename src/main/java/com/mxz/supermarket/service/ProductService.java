package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Product;

import java.math.BigDecimal;


/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 10:14 2020/1/14
 * @Modifued By:
 */
public interface ProductService {

    /**
     * 增加产品
     * @param product
     * @return
     */
    boolean addProduct(Product product);


    /**
     * 更新产品信息
     * @param product
     * @return
     */
    boolean updateProduct(Product product);

    /**
     * 根据产品id删除产品
     * @param productId
     * @return
     */
    boolean deleteProduct(int productId);

    /**
     * 根据价格查找产品
     * @param price
     * @return
     */
    PageInfo<Product> findProducts(Double price,int page,int limit);

    /**
     * 格局产品id查找产品
     * @param productId
     * @return
     */
    Product findProductById(int productId);


    /**
     * 根据产品类型查找产品
     * @param typeName
     * @return
     */
    PageInfo<Product> findProductsByType(String typeName,int page,int limit);


    /**
     * 根据产品名字模糊搜索
     * @param productName
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Product> findProductsByName(String productName,int page,int limit);

    /**
     * 加载全部产品
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Product> loadAllProduct(int page,int limit);

    /**
     * 根据产品名字精确查找产品
     * @param productName
     * @return
     */
    Product findProductByName(String productName);
}
