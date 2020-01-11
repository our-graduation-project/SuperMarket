package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.ProviderMapper;
import com.mxz.supermarket.model.Provider;
import com.mxz.supermarket.model.ProviderExample;
import com.mxz.supermarket.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;

    /**
     * 增加供货商
     * @param provider
     * @return
     */
    @Override
    public int addProvider(Provider provider) {
        return providerMapper.insert(provider);
    }

    /**
     * 修改供货商信息
     * @param provider
     * @return
     */
    @Override
    public boolean updateProvider(Provider provider) {
        int i = providerMapper.updateByPrimaryKeySelective(provider);
        return i > 0 ? true : false;
    }

    /**
     * 根据ID查询供货商
     * @param providerId
     * @return
     */
    @Override
    public Provider searchProviderByProviderId(Integer providerId) {
        Provider provider = providerMapper.selectByPrimaryKey(providerId);
        return provider;
    }

    /**
     * 根据名称查询供货商
     * @param providerName
     * @return
     */
    @Override
    public PageInfo<Provider> searchProviderByProviderName(int page, int limit,String providerName) {
        ProviderExample providerExample=new ProviderExample();
        providerExample.or().andProviderNameEqualTo(providerName);
        PageHelper.startPage(page,limit);
        List<Provider> providers = providerMapper.selectByExample(providerExample);
        PageInfo pageInfo=new PageInfo(providers,3);
        return pageInfo;
    }


    /**
     * 查询所有供货商
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Provider> searchProviders(int page, int limit) {
        ProviderExample providerExample=new ProviderExample();
        providerExample.or();
        PageHelper.startPage(page,limit);
        List<Provider> providers = providerMapper.selectByExample(providerExample);
        PageInfo pageInfo=new PageInfo(providers,3);
        return pageInfo;
    }

    /**
     * 根据ID删除供货商
     * @param providerId
     * @return
     */
    @Override
    public boolean deleteProvider(Integer providerId) {
        int i = providerMapper.deleteByPrimaryKey(providerId);
        return i>0 ? true :false;
    }
}
