/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.server.handle;

import com.youbaaa.im.common.session.Session;
import com.youbaaa.im.common.utils.SessionUtil;
import com.youbaaa.im.common.utils.UserIDUtil;
import com.youbaaa.im.protocol.request.LoginRequestPacket;
import com.youbaaa.im.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author huang.zhangh
 * @version LoginRequestHandler.java, v 0.1 2020-09-29 10:05
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    private LoginRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(msg.getVersion());
        loginResponsePacket.setUserName(msg.getUserName());
        if (valid(msg)) {
            String userId = UserIDUtil.uuid();
            loginResponsePacket.setSuccess(true);
            loginResponsePacket.setUserId(userId);
            System.out.println("[" + msg.getUserName() + "]登录成功");
            SessionUtil.bindSession(new Session(userId, msg.getUserName()), ctx.channel());
        } else {
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("账号密码校验失败!");
            System.out.println(new Date() + "«««««[" + msg.getUserName() + "]登录失败");
        }
        // 登录响应
        ctx.writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket msg) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}