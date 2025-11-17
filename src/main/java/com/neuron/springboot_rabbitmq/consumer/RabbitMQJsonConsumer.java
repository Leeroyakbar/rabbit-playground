package com.neuron.springboot_rabbitmq.consumer;

import com.neuron.springboot_rabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consume(User user) {
        log.info("Received json message: {}", user.toString());
    }
}
