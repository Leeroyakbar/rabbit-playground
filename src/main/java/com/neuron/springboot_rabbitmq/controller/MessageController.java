package com.neuron.springboot_rabbitmq.controller;


import com.neuron.springboot_rabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

    private final RabbitMQProducer producer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
