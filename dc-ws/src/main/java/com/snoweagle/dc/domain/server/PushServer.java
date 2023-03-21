package com.snoweagle.dc.domain.server;

import com.snoweagle.dc.domain.server.handler.ServerHandler;
import com.snoweagle.dc.domain.server.serializer.NettyEncoder;
import com.snoweagle.dc.domain.server.serializer.NettyDecoder;
import com.snoweagle.dc.domain.common.ServerConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PushServer implements Server {

    private ServerConfig config;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelFuture channelFuture;
    private ServerBootstrap serverBootstrap;

    public PushServer(ServerConfig config){
        this.config = config;
    }
    public void init() {
        bossGroup = new NioEventLoopGroup(0,new DefaultThreadFactory("ReceiveBoss", Thread.MAX_PRIORITY));
        workerGroup = new NioEventLoopGroup(0,new DefaultThreadFactory("ReceiveWorker", Thread.MAX_PRIORITY));

        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
//                .childOption(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(655350))
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_REUSEADDR, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_SNDBUF, 1024 * 1024)
                .childOption(ChannelOption.SO_RCVBUF, 1024 * 1024 * 5)
                .option(ChannelOption.WRITE_BUFFER_WATER_MARK, new WriteBufferWaterMark(1024 * 1024, 1024 * 1024 * 5))
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(
                        new NettyDecoder(),
                        new NettyEncoder(),
                        new ServerHandler()
                );
            }
        });
    }

    @Override
    public void start() {
        init();
        try {
            channelFuture = serverBootstrap.bind(config.getPort()).sync();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        log.info("push server is stopping");
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        if (channelFuture.channel() != null) {
            channelFuture.channel().close();
        }
        log.info("push server stop");
    }

    @Override
    public void restart() {

    }

}
