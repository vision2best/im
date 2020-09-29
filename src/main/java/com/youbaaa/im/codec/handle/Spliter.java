/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.codec.handle;

import com.youbaaa.im.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 帧解码器
 * 这里为了应对传输数据不是ByteBuf的基础类型
 * <p>
 * 包含4种帧解码器
 * （1）固定长度帧解码器 - FixedLengthFrameDecoder
 * （2）行分割帧解码器 - LineBasedFrameDecoder
 * （3）自定义分隔符帧解码器 - DelimiterBasedFrameDecoder
 * （4）自定义长度帧解码器 - LengthFieldBasedFrameDecoder
 *
 * @author huang.zhangh
 * @version Spliter.java, v 0.1 2020-09-29 10:02
 */
public class Spliter extends LengthFieldBasedFrameDecoder {
    private static final int LENGTH_FIELD_OFFSET = 7;
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in.getInt(in.readerIndex()) != PacketCodec.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }
}