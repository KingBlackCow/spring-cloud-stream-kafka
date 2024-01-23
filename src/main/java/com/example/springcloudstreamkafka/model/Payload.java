package com.example.springcloudstreamkafka.model;

import lombok.Data;

@Data
public class Payload {
    private int id;
    private int age;
    private String name;
    private String content;
}
