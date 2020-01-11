package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.ProducttypeMapper;
import com.mxz.supermarket.model.Producttype;
import com.mxz.supermarket.model.ProducttypeExample;
import com.mxz.supermarket.service.ProducttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducttypeServiceImpl implements ProducttypeService {

    @Autowired
    private ProducttypeMapper mapper;
    /**
     * 增加类型
     * @param producttype
     * @return
     */
    @Override
    public int addProducttype(Producttype producttype) {
        return mapper.insert(producttype);
    }

    /**
     * 修改类型
     * @param producttype
     * @return
     */
    @Override
    public boolean updateProducttype(Producttype producttype) {
        int i = mapper.updateByPrimaryKeySelective(producttype);
        return i>0 ?true:false;
    }

    /**
     * 根据ID查询类型
     * @param typeId
     * @return
     */
    @Override
    public Producttype searchTypeByTypeId(Integer typeId) {
        Producttype producttype = mapper.selectByPrimaryKey(typeId);
        return producttype;
    }

    /**
     * 根据名称查询类型
     * @param page
     * @param limit
     * @param typeName
     * @return
     */
    @Override
    public PageInfo<Producttype> searchTypeByTypeName(int page, int limit, String typeName) {
        ProducttypeExample example=new ProducttypeExample();
        example.or().andTypeNameEqualTo(typeName);
        PageHelper.startPage(page, limit);
        List<Producttype> producttypes = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(producttypes,3);
        return pageInfo;
    }

    /**
     * 查询所有类型
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Producttype> searchTypes(int page, int limit) {
        ProducttypeExample example=new ProducttypeExample();
        example.or();
        PageHelper.startPage(page, limit);
        List<Producttype> producttypes = mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(producttypes,3);
        return pageInfo;
    }

    /**
     * 根据ID删除类型
     * @param typeId
     * @return
     */
    @Override
    public boolean deleteType(Integer typeId) {
        int i = mapper.deleteByPrimaryKey(typeId);
        return i>0?true:false;
    }
}
