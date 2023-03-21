package com.snoweagle.dc.client;

import com.snoweagle.dc.client.handler.NettyClientHandler;
import com.snoweagle.dc.domain.server.messages.BizMessage;
import com.snoweagle.dc.domain.server.protocol.Message;
import com.snoweagle.dc.domain.server.protocol.MessageBody;
import com.snoweagle.dc.domain.server.protocol.MessageHead;
import com.snoweagle.dc.domain.server.protocol.MessageTypeEnum;
import com.snoweagle.dc.domain.server.serializer.NettyDecoder;
import com.snoweagle.dc.domain.server.serializer.NettyEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NettyClient implements Runnable {
    private Bootstrap bootstrap;
    private EventLoopGroup workerGroup;
    private Channel channel;
    private CountDownLatch latch = new CountDownLatch(1);

    private void init() {
        bootstrap = new Bootstrap();
        workerGroup = new NioEventLoopGroup();
        bootstrap.group(workerGroup).channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, netty.getConnectTimeout())
                .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                .option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 5)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
//                .option(ChannelOption.WRITE_BUFFER_WATER_MARK, new WriteBufferWaterMark(netty.getWaterMarkMin(), netty.getWaterMarkMax()))
                ;
        bootstrap.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new NettyDecoder());
                pipeline.addLast(new NettyEncoder());
                pipeline.addLast(new NettyClientHandler());
            }
        });
    }

    public Channel getChannel() {
        return channel;
    }

    public void connect() {
        init();
        try {
            ChannelFuture future = bootstrap.connect("127.0.0.1", 9901).sync();
            this.channel = future.channel();
            latch.countDown();
            log.info("[ 连接完成 ] -> [{}],suc:[{}]{} ", channel, future.isSuccess(),latch.getCount());
            log.info("{},{},{}", this.channel.isOpen(), this.channel.isWritable(), this.channel.isActive());
            this.channel.closeFuture().sync().addListener(new GenericFutureListener() {
                @Override
                public void operationComplete(Future future) throws Exception {
                    log.warn("[连接断开]");
                }
            });

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        } finally {
            latch.countDown();
            workerGroup.shutdownGracefully();
        }
    }
    @Override
    public void run() {
        connect();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public static void main(String[] args) {

        NettyClient client = new NettyClient();
        new Thread(client).start();
        CountDownLatch latch1 = client.getLatch();
        try {
            log.info("count:{}",latch1.getCount());
            boolean await = latch1.await(5, TimeUnit.SECONDS);

            log.info("count1:{}",latch1.getCount());
            if(await){
                MessageHead head = new MessageHead();
                head.setTopic("index_price");
                head.setType("PUBLIC");

                MessageBody body = new MessageBody();
                String s = "fdas答复 放大达到 =2=109999999fjdakl饭到了撒库拉进啦发大水";
                byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
                body.setDataLength(bytes.length);
                body.setData(bytes);
                body.setTopic("index_price");

                for(;;){
                    Message message = new Message();
                    message.setTimestamp(System.currentTimeMillis());
                    message.setType(MessageTypeEnum.MESSAGE.name());
                    BizMessage bizMessage = new BizMessage();
                    bizMessage.setHead(head);
                    bizMessage.setBody(body);
                    message.setMessage(bizMessage);

//                    log.info(JacksonUtil.obj2String(message));

                    client.getChannel().writeAndFlush(message);

                    TimeUnit.SECONDS.sleep(1);

                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}