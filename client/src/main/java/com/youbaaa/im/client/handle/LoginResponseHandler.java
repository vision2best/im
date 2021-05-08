/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.client.handle;

import com.youbaaa.im.common.session.Session;
import com.youbaaa.im.common.utils.SessionUtil;
import com.youbaaa.im.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author huang.zhangh
 * @version LoginResponseHandler.java, v 0.1 2020-09-29 10:05
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        String userId = msg.getUserId();
        String userName = msg.getUserName();
        if (msg.isSuccess()) {
            System.out.println("[" + userName + "]登录成功，userId 为: " + userId);
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
        } else {
            System.out.println("[" + userName + "]登录失败，原因：" + msg.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭!");
    }
}