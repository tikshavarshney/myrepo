package com.demo.springrabbitMQ.consumer;

import com.demo.springrabbitMQ.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consume(User user)
    {
        log.info(String.format("Received message : %s", user));
    }
}
