package com.demo.springrabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    @Value("${rabbitmq.json.queue.name}")
    private String jsonQueue;

    @Value("${rabbitmq.json.routing.key.name}")
    private String jsonRoutingKey;

    // spring bean for rabbitmq queue
    @Bean
    public Queue queue()
    {
        return new Queue(queue);
    }

    // spring bean for storing json in queue
    @Bean
    public Queue jsonQueue()
    {
        return new Queue(jsonQueue);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange(exchange);
    }

    // binding queue with exchange using routing key
    @Bean
    public Binding binding()
    {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    // binding json queue with exchange using json routing key
    @Bean
    public Binding jsonBinding()
    {
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(jsonRoutingKey);
    }

    // convert Java object to json object
    @Bean
    public MessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
