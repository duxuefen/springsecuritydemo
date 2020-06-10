package com.springsecurity.springsecuritydemo;


import com.springsecurity.springsecuritydemo.entity.Hello;
import com.springsecurity.springsecuritydemo.entity.Product;
import com.springsecurity.springsecuritydemo.service.HelloService;
import com.springsecurity.springsecuritydemo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest

class SpringsecuritydemoApplicationTests {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;


    @Autowired
    private HelloService service;

    @Test   //import org.junit.Test;   不要自己创建一个名称为Test类
    public void createIndex() {
        //创建空的索引库
        elasticsearchTemplate.createIndex(Hello.class);
        //添加映射
        elasticsearchTemplate.putMapping(Hello.class);
    }

    //添加文档对象
    @Test
    public void createDocument(){
        //批量创建hello对象
        for(Long i=1l;i<=10;i++){
            Hello hello=new Hello();
            hello.setId(i);
            hello.setTitle("新增title:"+i);
            hello.setContent("新增content:"+i);
            service.save(hello);
        }

    }

    //    根据id查询
    @Test
    public void getDocumentById(){
        Optional<Hello> optional = service.findById(2l);
        Hello hello = optional.get();
        System.out.println(hello);
    }

    //      查询所有
    @Test
    public void getAllDoucments(){

        Iterable<Hello> all = service.findAll();
        /*Iterator<Hello> iterator = all.iterator();
        while(iterator.hasNext()){
            Hello hello = iterator.next();
            System.out.println(hello);
        }*/

        //all.forEach(Consumer);Consumer接口通过@FunctionalInterface修饰，表示它是一个函数式接口
        //如果一个方法的形参是函数式接口，传递形参时可以使用Lambda表达式，特点使用箭头符号 形参(T t) -> 方法体内容
        //void accept(T t);
        all.forEach(item -> System.out.println(item) );
    }


    //更新文档<S extends T> S save(S var1);   保证传递的Hello对象中的id是已经存在的

    @Test
    public void updateDouctment(){
        Hello hello = new Hello();
        hello.setId(1l);
        hello.setTitle("球鞋");
        hello.setContent("权志龙小雏菊");
        service.save(hello);
    }

    //删除文档void deleteById(ID var1);    void deleteAll();
    @Test
    public void deleteDocumentById(){
        service.deleteById(10l);
    }

    //删除所有文档
    @Test
    public void deleteAllDoucments(){
        service.deleteAll();
    }



    //自定义查询
    @Test
    public void getDocumentsByTitle(){
        List<Hello> list = service.findByTitle("新增");
        System.out.println(list);
    }

    @Test
    public void getDocumentsByTitleAndPage(){
        List<Hello> list = service.findByTitle("新增");
        System.out.println(list);
        //展示第一页的数据，每页两条数据
        List<Hello> list1 = service.findByTitle("新增", PageRequest.of(0, 2));
        System.out.println(list1);
    }


}



