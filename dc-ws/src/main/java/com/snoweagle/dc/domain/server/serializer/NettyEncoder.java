package com.snoweagle.dc.domain.server.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snoweagle.dc.domain.server.protocol.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyEncoder extends MessageToByteEncoder<Message> {
	private static  final ObjectMapper objectMapper = new ObjectMapper();
	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf byteBuf) throws Exception {
		if(message == null){
			throw new Exception("未获得消息内容");
		}
		byte[] bytes = objectMapper.writeValueAsBytes(message);
		byteBuf.writeInt(bytes.length);
		byteBuf.writeBytes(bytes);
	}
}
