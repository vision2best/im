/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.codec;

import com.youbaaa.im.protocol.Packet;
import com.youbaaa.im.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author huang.zhangh
 * @version PacketEncoder.java, v 0.1 2020-09-29 09:45
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        PacketCodec.INSTANCE.encode(out, msg);
    }
}