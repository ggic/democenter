package com.snoweagle.dc.rpc.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/4/24 11:16 PM
 */
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {
    private Object result;

    public Object getResponse() {
        return result;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");
    }
}