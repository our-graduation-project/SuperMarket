package com.mxz.supermarket.controller;


import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Provider;
import com.mxz.supermarket.service.ProviderService;
import com.mxz.supermarket.utils.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    /**
     * 加载所有用户
     *
     * @return
     */
    @RequestMapping("admin/provider/loadProviders")
    public APIResult searchProviders(@RequestParam(value = "page",defaultValue = "0") int page
                                  , @RequestParam(value = "limit",defaultValue = "10") int limit) {
        System.out.println("加载供货商！");
        PageInfo<Provider> pageInfo = providerService.searchProviders(page, limit);
        if(pageInfo!=null &&pageInfo.getList()!=null&&pageInfo.getList().size()==0){
            return APIResult.genFailApiResponse500("查询失败");
        }
        System.out.println("pageInfo" +pageInfo);
        return new APIResult("加载供货商成功！",true,200,pageInfo);
    }
}
