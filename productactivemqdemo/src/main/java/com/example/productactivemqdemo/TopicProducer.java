package com.example.productactivemqdemo;


import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.ArrayList;
import java.util.List;

@Component
public class TopicProducer {
    //属性注入
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;
    /*//发送一条消息
    public void sendMsg(){
        jmsMessagingTemplate.convertAndSend(topic,"QueueProducer发送消息到队列");
    }
    //定时发送消息：每隔3秒发送一条消息？     微服务项目启动的时候自动执行使用@Scheduled修饰的方法
    */
    @Scheduled(fixedDelay = 3000l)
    public void sendMsgScheduled(){
        //设置发送的消息内容，操作商品表监听商品的库存是否为0，如果库存有为0的商品那么获取商品id
        //调用父项目中的ProductController中的请求
        List<Product> products = sendGet();
        System.out.println(products);
        //1,2
        //获取商品列表中的编号，组合成生产者发送的消息
        Product product1=products.get(0);
        Product product2=products.get(1);
        //生成TextMessage对象
        jmsMessagingTemplate.convertAndSend(topic,product1.getId()+"和"+product2.getId()+"库库存为零");
        System.out.println("------定时消息发送完成-----");
    }

    public List<Product>  sendGet(){
        List<Product> pros = new ArrayList<>();
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/getPinventory");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                pros = JSON.parseArray(EntityUtils.toString(responseEntity),Product.class);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pros;
    }
}

