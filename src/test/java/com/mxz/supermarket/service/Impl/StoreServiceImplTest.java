package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.SupermarketApplication;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.model.Store;
import com.mxz.supermarket.service.StoreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketApplication.class)
class StoreServiceImplTest {

    @Autowired
    private StoreService storeService;

    @Test
    void addStore() {
        Store store=new Store();
        store.setStoreId(1);
        store.setStoreName("巧克力");
        store.setInstoreTime(new Date());
        int i = storeService.addStore(store);
        System.out.println("i = " + i);
    }

    @Test
    void updateStore() {
    }

    @Test
    void searchStoreByStoreId() {
    }

    @Test
    void searchStoreBystoreName() {
    }

    @Test
    void searchStores() {
    }

    @Test
    void searchStoreByTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PageInfo<Store> pageInfo = storeService.searchStoreByTime(1, 1, sdf.parse("2020-01-08 20:44:13"), "Instore_time", OrderEnum.DESC);
        System.out.println("pageInfo = " + pageInfo.toString());
    }

    @Test
    void deleteStore() {
    }
}