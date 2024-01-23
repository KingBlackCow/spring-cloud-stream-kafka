package com.example.springcloudstreamkafka.api;

import com.example.springcloudstreamkafka.model.Payload;
import com.example.springcloudstreamkafka.producer.JsProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final JsProducer jsProducer;

    @PostMapping("/message")
    void message(@RequestBody Payload payload) {
        jsProducer.sendMessage(payload);
    }
}
