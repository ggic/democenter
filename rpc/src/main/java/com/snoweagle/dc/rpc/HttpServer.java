package com.snoweagle.dc.rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/4/16 4:42 PM
 */
public class HttpServer {

        private final int port;

        public HttpServer(int port) {
            this.port = port;
        }

        public static void main(String[] args) throws Exception {
            if (args.length != 1) {
                System.err.println(
                        "Usage: " + HttpServer.class.getSimpleName() +
                                " <port>");
                return;
            }
            int port = Integer.parseInt(args[0]);
            new HttpServer(port).start();
        }

        public void start() throws Exception {
            ServerBootstrap b = new ServerBootstrap();
            NioEventLoopGroup group = new NioEventLoopGroup();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            System.out.println("initChannel ch:" + ch);
                            ChannelPipeline entries = ch.pipeline()
                                    .addLast("decoder", new HttpRequestDecoder())   // 1
                                    .addLast("encoder", new HttpResponseEncoder())  // 2
                                    .addLast("aggregator", new HttpObjectAggregator(512 * 1024));    // 3
//                                    .addLast("handler", );// 4
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128) // determining the number of connections queued
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
            b.bind(port).sync();
        }
}
