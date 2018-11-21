package com.e4developer.kafkaintro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class KafkaWebController {

    @Autowired
    KafkaSender kafkaSender;

    @PostMapping("/kafka/{topicName}")
    public String sendToTopic(@PathVariable String topicName, @RequestBody String message) {
        log.info ("Sending '{}' to topic '{}'", message, topicName);

        kafkaSender.send(topicName, message);
        return "Message sent";
    }

}
