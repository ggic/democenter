package com.snoweagle.dc.server.serializer;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snoweagle.dc.server.messages.BizMessage;
import com.snoweagle.dc.server.protocol.Message;
import com.snoweagle.dc.server.protocol.MessageBody;
import com.snoweagle.dc.server.protocol.MessageHead;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

@Slf4j
public class NettyDecoder extends LengthFieldBasedFrameDecoder {
    private static  final ObjectMapper objectMapper = new ObjectMapper();
    private static final int VERSION_LENGTH = 4;
    private static final int HEADER_LENGTH = 4;
    private static final int BODY_LENGTH = 4;

    /**
     * [ lengthFieldLength ][message]
     */
    public NettyDecoder() {
        super(Integer.MAX_VALUE, 0, 4, 0, 0);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in == null) {
            log.error("in stream is null");
            return null;
        }
        System.out.println("byteBuf的容量为：" + in.capacity());
        System.out.println("byteBuf的可读容量为：" + in.readableBytes());
        System.out.println("byteBuf的可写容量为：" + in.writableBytes());

        String version = in.readBytes(VERSION_LENGTH).toString(CharsetUtil.UTF_8);
//        log.info("message version ->{}", version);
//
//        if(!version.startsWith("nv")){
//            log.error("version is illegal");
//            return null;
//        }
        int msgSize = in.readInt();
        log.info("message size ->{}", msgSize);

        byte[] data = new byte[msgSize];
//        in.readableBytes();
        in.readBytes(data);
        Message<BizMessage> message = objectMapper.readValue(data, new TypeReference<Message<BizMessage>>() {});
        return message;
    }
}