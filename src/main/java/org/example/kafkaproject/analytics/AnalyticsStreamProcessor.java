package org.example.kafkaproject.analytics;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AnalyticsStreamProcessor {
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsStreamProcessor.class);

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> analytics() {
        return input -> input
                .mapValues(value -> {
                    String result = "Processed: " + value.toUpperCase();
                    logger.info("🔁 Analytics Result = {}", result);
                    return result;
                });
    }

}


