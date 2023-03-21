package com.snoweagle.dc.server.protocol;

import lombok.Data;

@Data
public class MessageHead {
    //messagle type
    private String type;
    private Long userId;
    private String topic;
}
