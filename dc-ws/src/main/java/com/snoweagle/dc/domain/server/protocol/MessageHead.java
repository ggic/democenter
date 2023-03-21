package com.snoweagle.dc.domain.server.protocol;

import lombok.Data;

@Data
public class MessageHead {
    //messagle type
    private String type;
    private Long userId;
    private String topic;
}
