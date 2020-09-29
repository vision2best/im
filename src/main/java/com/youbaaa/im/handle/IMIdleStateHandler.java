/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 心跳检测机制
 *
 * @author huang.zhangh
 * @version IMIdleStateHandler.java, v 0.1 2020-09-28 16:29
 */
public class IMIdleStateHandler extends IdleStateHandler {
    private static final int READER_IDLE_TIME = 15;

    /**
     * readerIdleTime读空闲超时时间设定，如果channelRead()方法超过readerIdleTime时间未被调用则会触发超时事件调用userEventTrigger()方法；
     * <p>
     * writerIdleTime写空闲超时时间设定，如果write()方法超过writerIdleTime时间未被调用则会触发超时事件调用userEventTrigger()方法；
     * <p>
     * allIdleTime所有类型的空闲超时时间设定，包括读空闲和写空闲；
     * <p>
     * unit时间单位，包括时分秒等；
     */
    public IMIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READER_IDLE_TIME + ":秒内没读到数据，关闭连接");
        ctx.channel().close();
    }

}