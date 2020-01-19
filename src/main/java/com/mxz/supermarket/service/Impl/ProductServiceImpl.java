package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.ProductMapper;
import com.mxz.supermarket.model.Product;
import com.mxz.supermarket.model.ProductExample;
import com.mxz.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 10:36 2020/1/14
 * @Modifued By:
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    /**
     * 增加产品
     *
     * @param product
     * @return
     */
    @Override
    public boolean addProduct(Product product) {

        int insert = productMapper.insert(product);
        if(insert > 0){
            return true;
        }
        return false;
    }

    /**
     * 更新产品信息
     *
     * @param product
     * @return
     */
    @Override
    public boolean updateProduct(Product product) {

        int i = productMapper.updateByPrimaryKeySelective(product);
        if(i > 0){
            return true;
        }

        return false;
    }

    /**
     * 根据产品id删除产品
     *
     * @param productId
     * @return
     */
    @Override
    public boolean deleteProduct(int productId) {

        int i = productMapper.deleteByPrimaryKey(productId);
        if(i > 0){
            return true;
        }

        return false;
    }

    /**
     * 根据价格查找产品 查找结果为采购价格或者售卖价格为这个查找价格的商品
     *
     * @param price
     * @return
     */
    @Override
    public PageInfo<Product> findProducts(Double price,int page,int limit) {
        ProductExample productExample = new ProductExample();
        productExample.or().andPurchasePriceEqualTo(price).andSalePriceEqualTo(price);
        PageHelper.startPage(page,limit);
        List<Product> products = productMapper.selectByExample(productExample);
        PageInfo pageInfo = new PageInfo(products,3);
        return pageInfo;
    }

    /**
     * 格局产品id查找产品
     *
     * @param productId
     * @return
     */
    @Override
    public Product findProductById(int productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    /**
     * 根据产品类型查找产品
     *
     * @param typeName
     * @return
     */
    @Override
    public PageInfo<Product> findProductsByType(String typeName,int page,int limit) {
        ProductExample productExample = new ProductExample();
        productExample.or().andTypeNameEqualTo(typeName);
        PageHelper.startPage(page,limit);
        List<Product> products = productMapper.selectByExample(productExample);
        PageInfo pageInfo = new PageInfo(products,3);
        return pageInfo;
    }

    /**
     * 根据产品名字搜索
     *
     * @param productName
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Product> findProductsByName(String productName, int page, int limit) {
        ProductExample productExample = new ProductExample();
        if(productName == null){
            productExample.or();
        }else{
            productExample.or().andProductNameLike(productName+"%");
        }
        PageHelper.startPage(page,limit);
        List<Product> products = productMapper.selectByExample(productExample);
        PageInfo pageInfo = new PageInfo(products,3);
        return pageInfo;
    }

    /**
     * 加载全部产品
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Product> loadAllProduct(int page, int limit) {
        ProductExample productExample = new ProductExample();
        productExample.or();
        PageHelper.startPage(page, limit);
        List<Product> admins = productMapper.selectByExample(productExample);
        PageInfo pageInfo=new PageInfo(admins,3);
        return pageInfo;
    }

    /**
     * 根据产品名字精确查找产品
     *
     * @param productName
     * @return
     */
    @Override
    public Product findProductByName(String productName) {
        ProductExample productExample = new ProductExample();
        productExample.or().andProductNameEqualTo(productName);
        List<Product> products = productMapper.selectByExample(productExample);
        if(products.isEmpty()){
            return null;
        }
        return products.get(0);
    }


}