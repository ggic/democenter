package com.snoweagle.dc.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snoweagle.dc.server.messages.BizMessage;
import com.snoweagle.dc.server.protocol.Message;
import com.snoweagle.dc.server.protocol.MessageBody;
import com.snoweagle.dc.server.protocol.MessageHead;
import com.snoweagle.dc.server.protocol.MessageTypeEnum;
import com.snoweagle.dc.tools.JacksonUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext context, Message msg) {
            log.info("receive message ->client:{},msg:{} ",context.channel().remoteAddress(), JacksonUtil.obj2String(msg));
            log.info("耗时:{}",System.currentTimeMillis() - msg.getTimestamp());
            if(msg.getType().equals(MessageTypeEnum.MESSAGE.name())){
                BizMessage message = (BizMessage) msg.getMessage();


                MessageBody body = message.getBody();
                log.info("解析body:{}", new String(body.getData()));
                Message response  = new Message();
                response.setType(MessageTypeEnum.SERVER_ACK.name());
                context.channel().writeAndFlush(response);
        }

    }
}