package com.springsecurity.springsecuritydemo.service;

import com.springsecurity.springsecuritydemo.entity.Product;
import com.springsecurity.springsecuritydemo.entity.ProductExample;
import com.springsecurity.springsecuritydemo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public  int adds(Product product){
        return  productMapper.insertSelective(product);
    }
    public List<Product> getAll(){

        ProductExample p=new ProductExample();
        p.createCriteria().andShopnameLike("%店");
       return productMapper.selectByExample(p);
    }
}
