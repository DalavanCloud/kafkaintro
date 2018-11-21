package com.e4developer.kafkaintro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        log.info("Sending Message '{}' to topic '{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
        log.info("Message '{}' sent to topic '{}'", payload, topic);
    }


}
