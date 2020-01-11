package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.ProductshelfMapper;
import com.mxz.supermarket.model.Productshelf;
import com.mxz.supermarket.model.ProductshelfExample;
import com.mxz.supermarket.service.ProductshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductshelfServiceImpl implements ProductshelfService {

    @Autowired
    private ProductshelfMapper productshelfMapper;
    /**
     * 增加货架
     * @param productshelf
     * @return
     */
    @Override
    public int addShelf(Productshelf productshelf) {
        return productshelfMapper.insert(productshelf);
    }

    /**
     * 修改货架
     * @param productshelf
     * @return
     */
    @Override
    public boolean updateShelf(Productshelf productshelf) {
        int i = productshelfMapper.updateByPrimaryKeySelective(productshelf);
        return i > 0 ? true : false;
    }

    /**
     * 根据ID查询货架
     * @param shelfId
     * @return
     */
    @Override
    public Productshelf searchShelfByShelfId(Integer shelfId) {
        Productshelf productshelf = productshelfMapper.selectByPrimaryKey(shelfId);
        return productshelf;
    }

    /**
     * 根据名称查询货架
     * @param shelfName
     * @return
     */
    @Override
    public PageInfo<Productshelf> searchShelfByShelfName(int page, int limit,String shelfName) {
        ProductshelfExample example=new ProductshelfExample();
        example.or().andShelfNameEqualTo(shelfName);
        PageHelper.startPage(page, limit);
        List<Productshelf> productshelves = productshelfMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(productshelves,3);
        return pageInfo;
    }

    /**
     * 查询所有货架
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Productshelf> searchShelfs(int page, int limit) {
        ProductshelfExample example=new ProductshelfExample();
        example.or();
        PageHelper.startPage(page, limit);
        List<Productshelf> productshelves = productshelfMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(productshelves,3);
        return pageInfo;
    }

    /**
     * 根据ID查询货架
     * @param shelfId
     * @return
     */
    @Override
    public boolean deleteShelf(Integer shelfId) {
        int i = productshelfMapper.deleteByPrimaryKey(shelfId);
        return i>0 ?true :false;
    }
}
