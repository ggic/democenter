package com.snoweagle.dc.server.messages;

import com.snoweagle.dc.server.protocol.MessageBody;
import com.snoweagle.dc.server.protocol.MessageHead;
import lombok.Data;

import java.util.UUID;

@Data
public class BizMessage {
    //id
    private String id ;
    //消息类型
    private MessageHead head;
    //消息长度
    private MessageBody body;

    public BizMessage() {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
    }
}
