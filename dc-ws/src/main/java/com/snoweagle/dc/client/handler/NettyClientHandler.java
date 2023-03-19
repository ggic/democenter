package com.snoweagle.dc.client.handler;

import com.snoweagle.dc.server.protocol.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        log.debug("Channel#Registered.注册Channel信息.node:{}");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {

//        UserCache.getInstance().offline(node);
//        try {
//            log.info("[ 等待10S重连 ]");
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            log.warn(e.getMessage(), e);
//        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("Channel Active.激活Channel信息.node:{}");

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        try {
            log.debug("收到服务端消息:{}", msg);

        } catch (Exception e) {
            log.warn("[ 读数据异常 ] -> {}", e.getMessage());
            log.warn(e.getMessage(), e);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        log.warn("hanlder_exceptionCaught:" + cause.getMessage(), cause);
        cause.printStackTrace();
        // ctx.channel().close();
    }

}
