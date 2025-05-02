package org.example.kafkaproject.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Bean
    public Consumer<String> consume() {
        return message -> logger.info("🔔 Consumed: {}", message);
    }
}

