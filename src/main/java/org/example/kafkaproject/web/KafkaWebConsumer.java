package org.example.kafkaproject.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaWebConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaWebConsumer.class);
    private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    @KafkaListener(topics = "analytics-results", groupId = "web-group")
    public void listen(String message) {
        logger.info("📩 New analytics update: {}", message);
        emitters.forEach(emitter -> {
            try {
                emitter.send(message);
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        });
    }
}

