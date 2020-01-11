package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.SupermarketApplication;
import com.mxz.supermarket.model.Provider;
import com.mxz.supermarket.service.ProviderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketApplication.class)
class ProviderServiceImplTest {

    @Autowired
    private ProviderService providerService;
    @Test
    void addProvider() {
        Provider provider=new Provider();
        provider.setProviderId(2);
        provider.setProviderName("北京食用油");
        int i = providerService.addProvider(provider);
        System.out.println("i = " + i);
    }

    @Test
    void updateProvider() {
        System.out.println(providerService.updateProvider(new Provider(1,"上海食用油批发市场")));
    }

    @Test
    void searchProviderByProviderId() {
        Provider provider = providerService.searchProviderByProviderId(1);
        System.out.println("provider = " + provider);
    }

    @Test
    void searchProviderByProviderName() {
        PageInfo<Provider> pageInfo = providerService.searchProviderByProviderName(1, 3, "上海食用油批发市场");
        System.out.println("pageInfo = " + pageInfo.toString());
    }
    @Test
    void searchProviders() {
        PageInfo<Provider> pageInfo = providerService.searchProviders(1, 3);
        System.out.println("pageInfo = " + pageInfo.toString());
    }

    @Test
    void deleteProvider() {
        boolean b = providerService.deleteProvider(2);
        System.out.println("b = " + b);
    }
}