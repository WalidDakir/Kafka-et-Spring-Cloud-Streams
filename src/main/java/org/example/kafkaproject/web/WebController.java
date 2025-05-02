package org.example.kafkaproject.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class WebController {

    private final KafkaWebConsumer kafkaWebConsumer;

    @Autowired
    public WebController(KafkaWebConsumer kafkaWebConsumer) {
        this.kafkaWebConsumer = kafkaWebConsumer;
    }

    @GetMapping("/analytics-stream")
    public SseEmitter streamAnalytics() {
        return kafkaWebConsumer.subscribe();
    }
}

