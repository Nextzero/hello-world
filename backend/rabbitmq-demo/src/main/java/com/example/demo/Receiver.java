package com.example.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
    bindings = {
        @QueueBinding(
            value = @Queue("hello"),
            exchange = @Exchange(value = "amq.topic", type = ExchangeTypes.TOPIC),
            key = "domi"
        )
    }
)
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }
}