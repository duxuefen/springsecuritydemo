package com.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class shoujiConsumer {
    @JmsListener(destination = "${topic-boot-name}")
    public void reciveMsg(TextMessage textMessage)throws Exception{
        System.out.println("手机端接受的消息"+textMessage.getText());
    }
}
