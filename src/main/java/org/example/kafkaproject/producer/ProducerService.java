package org.example.kafkaproject.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final MessageChannel outputChannel;

    @Autowired
    public ProducerService(MessageChannel outputChannel) {
        this.outputChannel = outputChannel;
    }

    public void sendMessage(String message) {
        outputChannel.send(MessageBuilder.withPayload(message).build());
    }
}


