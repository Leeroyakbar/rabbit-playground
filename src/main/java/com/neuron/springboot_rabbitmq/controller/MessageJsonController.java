package com.neuron.springboot_rabbitmq.controller;

import com.neuron.springboot_rabbitmq.dto.User;
import com.neuron.springboot_rabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/json")
public class MessageJsonController {

    private final RabbitMQJsonProducer producer;


    @PostMapping("/send")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent successfully");
    }
}
