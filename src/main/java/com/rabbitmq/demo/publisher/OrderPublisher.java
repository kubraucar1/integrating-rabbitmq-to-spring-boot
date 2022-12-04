package com.rabbitmq.demo.publisher;

import com.rabbitmq.demo.config.MessagingConfig;
import com.rabbitmq.demo.dto.Order;
import com.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName)
    {
        order.setOrderId(UUID.randomUUID().toString());
        //restauranService
        //paymentService
        OrderStatus orderStatus = new OrderStatus(order,"Progress","order placed succesfully in"+restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);
        return "Success!";

    }}
