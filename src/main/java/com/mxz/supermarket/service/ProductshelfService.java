package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Productshelf;

public interface ProductshelfService {

    /**
     * 增加货架
     * @param productshelf
     * @return
     */
    int addShelf(Productshelf productshelf);

    /**
     * 修改货架
     * @param productshelf
     * @return
     */
    boolean updateShelf(Productshelf productshelf);


    /**
     * 根据ID查询货架
     * @param shelfId
     * @return
     */
    Productshelf searchShelfByShelfId(Integer shelfId);

    /**
     * 根据名字查询货架
     * @param shelfName
     * @return
     */
    PageInfo<Productshelf> searchShelfByShelfName(int page, int limit,String shelfName);

    /**
     * 查询所有货架
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Productshelf> searchShelfs(int page, int limit);

    /**
     * 根据ID删除货架
     * @param shelfId
     * @return
     */
    boolean deleteShelf(Integer shelfId);
}
