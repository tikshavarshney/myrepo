package com.demo.springrabbitMQ.controller;

import com.demo.springrabbitMQ.dto.User;
import com.demo.springrabbitMQ.producer.RabbitMQJsonProducer;
import com.demo.springrabbitMQ.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/json/message")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user)
    {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ Producer...");
    }
}
