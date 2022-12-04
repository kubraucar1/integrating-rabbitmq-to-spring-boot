package com.rabbitmq.demo.consumer;

import com.rabbitmq.demo.config.MessagingConfig;
import com.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessagefromQueue(OrderStatus orderStatus){
        System.out.println("Message resives from queue :"+orderStatus);
    }
}
