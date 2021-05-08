/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.codec;

import com.youbaaa.im.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author huang.zhangh
 * @version PacketDecoder.java, v 0.1 2020-09-29 09:46
 */
public class PacketDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(PacketCodec.INSTANCE.decode(msg));

    }
}