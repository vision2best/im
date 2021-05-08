/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.client.handle;

import com.youbaaa.im.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author huang.zhangh
 * @version MessageResponseHandler.java, v 0.1 2020-09-29 13:49
 */
@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        String fromUserId = msg.getFromUserId();
        String fromUserName = msg.getFromUserName();
        System.out.println("收到[" + fromUserId + "-" + fromUserName + "]发来的消息：" + msg.getMessage());

    }
}