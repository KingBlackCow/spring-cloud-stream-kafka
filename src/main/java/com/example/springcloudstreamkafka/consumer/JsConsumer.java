package com.example.springcloudstreamkafka.consumer;

import com.example.springcloudstreamkafka.model.Payload;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
public class JsConsumer implements Consumer<Message<Payload>> {
    @Override
    public void accept(Message<Payload> message) {
        System.out.println("컨슈머 확인 메시지 확인: " + message.getPayload());
    }
}
