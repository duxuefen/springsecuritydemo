package com.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;
@Component
public class emailConsumer {
    @JmsListener(destination = "${topic-boot-name}")
    public void recivMsg(TextMessage textMessage)throws Exception{
        System.out.println("邮箱端接受的消息"+textMessage.getText());
    }
}
