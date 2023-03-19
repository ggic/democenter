package com.snoweagle.dc.server.protocol;

import lombok.Data;

@Data
public class MessageBody {

    private Long userId;

    private String topic;
    //消息体
    private byte[] data;

    private Integer dataLength;
}