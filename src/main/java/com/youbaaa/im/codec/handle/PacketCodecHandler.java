/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.codec.handle;

import com.youbaaa.im.protocol.Packet;
import com.youbaaa.im.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author huang.zhangh
 * @version PacketCodecHandler.java, v 0.1 2020-09-29 09:56
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {
    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    private PacketCodecHandler() {

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.channel().alloc().ioBuffer();
        PacketCodec.INSTANCE.encode(buffer, msg);
        out.add(buffer);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(PacketCodec.INSTANCE.decode(msg));
    }
}