package com.snoweagle.dc.domain.server.serializer;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snoweagle.dc.domain.server.messages.BizMessage;
import com.snoweagle.dc.domain.server.protocol.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyDecoder extends LengthFieldBasedFrameDecoder {
    private static  final ObjectMapper objectMapper = new ObjectMapper();

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

        if(in.readableBytes() > 4){
            in.markReaderIndex();

            int length = in.readInt();
            log.info("message length ->{}", length);

            int readableBytes = in.readableBytes();
            if(readableBytes < length){
                log.warn("Not all messages were received-->{}" , readableBytes);
                in.resetReaderIndex();
                return null;
            }

            byte[] data = new byte[length];
            in.readBytes(data);
            Message<BizMessage> message = objectMapper.readValue(data, new TypeReference<Message<BizMessage>>() {});
            return message;
        }
        return  null;
    }
}