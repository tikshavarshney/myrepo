package com.demo.springrabbitMQ.producer;

import com.demo.springrabbitMQ.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.routing.key.name}")
    private String jsonRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user)
    {
        log.info(String.format("Message sent : %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }
}
