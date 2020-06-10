package com.springsecurity.springsecuritydemo.controller;

import com.springsecurity.springsecuritydemo.JsoupUtils;
import com.springsecurity.springsecuritydemo.entity.Product;
import com.springsecurity.springsecuritydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private JsoupUtils jsoupUtils;
    @Autowired
    private ProductService productService;

    @RequestMapping("adds")
    @ResponseBody
    public String add(){
        List<Product> list =jsoupUtils.getProsByJsoup();
        for (Product i:list
             ) {
            productService.adds(i);
        }
        return "成功";
    }


    @RequestMapping("/getPinventory")
    @ResponseBody //响应 JSON
    public List<Product> getPinventory(){
//模拟，假设 id=1 和 id=2 的商品库存=0
        List<Product> pros = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        pros.add(product);
        Product product2 = new Product();
        product2.setId(2);
        pros.add(product2);
        return pros;
    }
    @RequestMapping("/get")
    @ResponseBody
    public List<Product> getAll(){
        return productService.getAll();
    }

}
