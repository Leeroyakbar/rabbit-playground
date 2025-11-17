package com.neuron.springboot_rabbitmq.publisher;


import com.neuron.springboot_rabbitmq.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
     private String exchange;


    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user) {
        log.info("Sending json message: {}", user.toString());
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
