package com.mxz.supermarket.controller;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Admin;
import com.mxz.supermarket.model.Product;
import com.mxz.supermarket.service.ProductService;
import com.mxz.supermarket.utils.APIResult;
import com.mxz.supermarket.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 17:01 2020/1/14
 * @Modifued By:
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 加载所有的产品
     * @param map
     * @return
     */
    @RequestMapping("/admin/product/loadallproduct")
    public APIResult loadAllProduct(@RequestBody Map map){
        int page ;
        int limit;
        //对请求中的page 和limit做处理
        if(map.get("page") == null){
            page = 0;
        }else{
            page = Integer.parseInt(map.get("page").toString());
        }

        if(map.get("limit") == null){
            limit = 10;
        }else{
            limit = Integer.parseInt(map.get("limit").toString());
        }

        PageInfo<Product> productPageInfo = productService.loadAllProduct(page, limit);

        return APIResult.genSuccessApiResponse(productPageInfo);
    }

    @RequestMapping("/admin/product/addproduct")
    public APIResult addProduct(@RequestBody Product product){
        if(product == null){
            LogUtils.getControllerLogger().info("增加product是发生参数错误！");
            return APIResult.genFailApiResponse400("输入数据错误！");
        }
        Product productByName = productService.findProductByName(product.getProductName());
        if(productByName != null){
            return APIResult.genFailApiResponse400("该产品已存在！");
        }
        boolean b = productService.addProduct(product);
        if(b){
            return APIResult.genSuccessApiResponse("添加产品成功！");
        }
        return APIResult.genFailApiResponse400("添加产品失败！");
    }

    @GetMapping("/admin/product/delproduct/{id}")
    public APIResult delProduct(@PathVariable("id") Integer id){
        if(id == null){
            return APIResult.genFailApiResponse400("删除失败！");
        }
        boolean b = productService.deleteProduct(id);
        if(b){
            return APIResult.genSuccessApiResponse("删除成功！");
        }
        return APIResult.genFailApiResponse400("删除失败！");
    }

    @GetMapping("/admin/product/toproductdetail/{id}")
    public APIResult toProductDetail(@PathVariable("id") Integer id){
        if(id == null){
            return APIResult.genFailApiResponse400("加载产品时发生错误！");
        }
        Product productById = productService.findProductById(id);
        return APIResult.genSuccessApiResponse("加载成功！",productById);
    }

    @RequestMapping("/admin/product/updateproduct")
    public APIResult updateProduct(@RequestBody Product product){
        if(product == null){
            return APIResult.genFailApiResponse400("修改产品时发生错误！");
        }
        System.out.println("product----"+product);
        boolean b = productService.updateProduct(product);
        if(b){
            return APIResult.genSuccessApiResponse("修改产品成功！");
        }
        return APIResult.genFailApiResponse400("修改产品失败!");
    }

    @RequestMapping("/admin/product/searchproductbyname")
    public APIResult searchProductByName(@RequestBody Map map ){
        int page ;
        int limit;
        String productName ;
        //对请求中的page 和limit做处理
        if(map.get("page") == null){
            page = 0;
        }else{
            page = Integer.parseInt(map.get("page").toString());
        }

        if(map.get("limit") == null){
            limit = 10;
        }else{
            limit = Integer.parseInt(map.get("limit").toString());
        }
        if(map.get("productName").toString() == null){
            productName = null;
        }else{
            productName = map.get("productName").toString();
        }
        PageInfo<Product> productsByName = productService.findProductsByName(productName, page, limit);

        return APIResult.genSuccessApiResponse(productsByName);
    }


}