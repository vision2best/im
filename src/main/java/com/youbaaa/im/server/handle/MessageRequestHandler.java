/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.server.handle;

import com.youbaaa.im.protocol.request.MessageRequestPacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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

    }
}