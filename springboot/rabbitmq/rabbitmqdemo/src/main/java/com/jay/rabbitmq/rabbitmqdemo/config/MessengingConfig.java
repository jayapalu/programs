package com.jay.rabbitmq.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public class MessengingConfig {

    public static final String PRACTICE_RBMQ_QUEUE = "practice_rbmq_queue";
    public static final String PRACTICE_RBMQ_EXCHANGE = "practice_rbmq_exchange";
    public static final String PRACTICE_RBMQ_ROUTING_KEY1 = "practice_routing_key";

    @Bean
    public Queue queue() {
        return new Queue(PRACTICE_RBMQ_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(PRACTICE_RBMQ_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queueName, TopicExchange topicExchange){
        return BindingBuilder.bind(queueName).to(topicExchange).with(PRACTICE_RBMQ_ROUTING_KEY1);
    }

    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();

    }

    @Bean
    public AmqpTemplate rbmqTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }


}
