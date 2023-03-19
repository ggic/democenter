package com.snoweagle.dc.server.protocol;

import lombok.Data;

import java.util.UUID;

@Data
public class Message<T> {
    private String id ;
    private long timestamp;
    private String type;
    private T  message;

    public Message() {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
    }
}
