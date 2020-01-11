package com.mxz.supermarket.service;


import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Provider;

public interface ProviderService {

    /**
     * 增加供货商
     * @param provider
     * @return
     */
    int addProvider(Provider provider);

    /**
     * 修改供货商
     * @param provider
     * @return
     */
    boolean updateProvider(Provider provider);


    /**
     * 根据ID查询供货商
     * @param providerId
     * @return
     */
    Provider searchProviderByProviderId(Integer providerId);

    /**
     * 根据名字查询供货商
     * @param providerName
     * @return
     */
    PageInfo<Provider> searchProviderByProviderName(int page, int limit,String providerName);

    /**
     * 查询所有供货商
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Provider> searchProviders(int page, int limit);

    /**
     * 根据ID删除供货商
     * @param providerId
     * @return
     */
    boolean deleteProvider(Integer providerId);
}
