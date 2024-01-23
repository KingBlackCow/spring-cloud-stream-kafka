package com.example.springcloudstreamkafka.producer;

import com.example.springcloudstreamkafka.model.Payload;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Component
public class JsProducer implements Supplier<Flux<org.springframework.messaging.Message<Payload>>> {

    private final Sinks.Many<Message<Payload>> sinks = Sinks.many().unicast().onBackpressureBuffer();

    public void sendMessage(Payload payload) {
        Message<Payload> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.KEY, String.valueOf(payload.getAge()))
                .build();
        sinks.emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Override
    public Flux<Message<Payload>> get() {
        return sinks.asFlux();
    }
}
