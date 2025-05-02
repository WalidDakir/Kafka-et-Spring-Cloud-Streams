package org.example.kafkaproject.supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.function.Supplier;

@Service
public class SupplierService {

    @Bean
    public Supplier<String> supply() {
        return () -> "📦 Message at " + Instant.now();
    }
}


