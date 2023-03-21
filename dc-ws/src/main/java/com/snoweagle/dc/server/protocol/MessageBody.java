package com.snoweagle.dc.server.protocol;

import lombok.Data;

@Data
public class MessageBody {
    //消息体
    private byte[] data;

    //user id
    private Long userId;
    //topic
    private String topic;

    private Integer dataLength;
}