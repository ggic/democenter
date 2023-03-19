package com.snoweagle.dc.server.protocol;

import lombok.Data;

@Data
public class MessageHead {
    private Long userId;
    private String topic;
    private String type;
}
