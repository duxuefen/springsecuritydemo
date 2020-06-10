package com.springsecurity.springsecuritydemo.mapper;


import com.springsecurity.springsecuritydemo.entity.Hello;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//调用CrudRepository<T, ID>接口中声明的方法
//<Hello,Long>   Long表示Hello中的id属性
@Repository
public interface HelloMapper extends ElasticsearchRepository<Hello,Long> {
//继承CrudRepository<T, ID>接口中声明的方法


    //自定义查询方法
    public List<Hello> findByTitle(String title);

    //自定义查询方法,根据title查询并按照设置属性进行分页Pageable展示
    public List<Hello> findByTitle(String title, Pageable pageable);
}
