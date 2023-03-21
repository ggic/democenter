package com.snoweagle.dc.domain.ws;

import com.snoweagle.dc.domain.server.Server;
import com.snoweagle.dc.domain.common.ServerConfig;
import com.snoweagle.dc.domain.ws.handle.WebSocketServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebsocketServer implements Server {
    private ServerConfig config;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ChannelFuture channelFuture;
    private ServerBootstrap serverBootstrap;

    public WebsocketServer(ServerConfig config){
        this.config = config;
    }

    private void init() {
         bossGroup = new NioEventLoopGroup();
         workerGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                // 第2次握手服务端向客户端发送请求确认，同时把此连接放入队列A中，
                // 然后客户端接受到服务端返回的请求后，再次向服务端发送请求，表示准备完毕，此时服务端收到请求，把这个连接从队列A移动到队列B中，
                // 此时A+B的总数，不能超过SO_BACKLOG的数值，满了之后无法建立新的TCP连接,2次握手后和3次握手后的总数
                // 当服务端从队列B中按照FIFO的原则获取到连接并且建立连接[ServerSocket.accept()]后，B中对应的连接会被移除，这样A+B的数值就会变小
                //此参数对于程序的连接数没影响，会影响正在准备建立连接的握手。
                .option(ChannelOption.SO_BACKLOG, 1024)//
                //启用心跳，双方TCP套接字建立连接后（即都进入ESTABLISHED状态），
                // 并且在两个小时左右上层没有任何数据传输的情况下，这套机制才会被激活，TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //TCP协议中，TCP总是希望每次发送的数据足够大，避免网络中充满了小数据块。
                // Nagle算法就是为了尽可能的发送大数据快。
                // TCP_NODELAY就是控制是否启用Nagle算法。
                // 如果要求高实时性，有数据发送时就马上发送，就将该选项设置为true关闭Nagle算法；
                // 如果要减少发送次数减少网络交互，就设置为false等累积一定大小后再发送。默认为false。
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_SNDBUF, 1024)
                .childOption(ChannelOption.SO_RCVBUF, 1024)
                //是否允许重复绑定端口，重复启动，会把端口从上一个使用者上抢过来
                .option(ChannelOption.SO_REUSEADDR, true)
                //连接超时毫秒
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5*1000)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch)
                            throws Exception {
                        // http 的解码器
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new HttpServerCodec())
                                //  负责将 Http 的一些信息例如版本
                                // 和 Http 的内容继承一个 FullHttpRequesst
                                .addLast(new HttpObjectAggregator(65536))
                                //心跳检查机制,如果超过多久没有发生对应事件,将触发userEventTrigger,设置为0将代表不检测,此处只做读事件检测
                                .addLast(new IdleStateHandler(10, 0, 0))
//                                // 大文件写入的类
//                                .addLast(new ChunkedWriteHandler())
                                // websocket 处理类
                                .addLast(new WebSocketServerHandler());
                    }
                });

    }

    @Override
    public void start() {
        init();
        try {
            channelFuture = serverBootstrap.bind(config.getPort());
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    this.stop();
                }
            });
            channelFuture.sync();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        log.info("ws server is stopping");
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        if (channelFuture.channel() != null) {
            channelFuture.channel().close();
        }
        log.info("ws server stop");
    }

    @Override
    public void restart() {

    }
}
