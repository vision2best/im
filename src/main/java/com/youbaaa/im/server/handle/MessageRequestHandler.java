/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.server.handle;

import com.youbaaa.im.protocol.request.MessageRequestPacket;
import com.youbaaa.im.protocol.response.GroupMessageResponsePacket;
import com.youbaaa.im.protocol.response.MessageResponsePacket;
import com.youbaaa.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author huang.zhangh
 * @version MessageRequestHandler.java, v 0.1 2020-09-29 13:52
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    private MessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        // 1.拿到 userId 构造消息的响应
        String userId = msg.getToUserId();
        String message = msg.getMessage();
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserId(msg.getFromUserId());
        responsePacket.setFromUserName(msg.getFromUserName());
        responsePacket.setMessage(message);
        // 2. 拿到对应的channel，写到客户端
        Channel channel = SessionUtil.getChannel(userId);
        channel.writeAndFlush(responsePacket);
    }
}