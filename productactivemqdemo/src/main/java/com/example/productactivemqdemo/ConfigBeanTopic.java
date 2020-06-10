package com.example.productactivemqdemo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;


import javax.jms.Topic;

@Configuration
@EnableJms
public class ConfigBeanTopic {
    //属性注入的方式
    @Value("${topic-boot-name}")
    private String topicName;
    //创建队列Queue并设置队列名称
    @Bean
    public Topic createQueue(){
        return new ActiveMQTopic(topicName);
    }
}
