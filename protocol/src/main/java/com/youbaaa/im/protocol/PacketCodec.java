/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol;

import com.youbaaa.im.common.serializer.Serializer;
import com.youbaaa.im.common.serializer.impl.JSONSerializer;
import com.youbaaa.im.protocol.request.*;
import com.youbaaa.im.protocol.response.*;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

import static com.youbaaa.im.protocol.command.Command.*;

/**
 * <pre>
 * **********************************************************************
 *                                Protocol
 * +-------+----------+------------+----------+---------+---------------+
 * |       |          |            |          |         |               |
 * |   4   |     1    |     1      |    1     |    4    |       N       |
 * +--------------------------------------------------------------------+
 * |       |          |            |          |         |               |
 * | magic |  version | serializer | command  |  length |      body     |
 * |       |          |            |          |         |               |
 * +-------+----------+------------+----------+---------+---------------+
 * 消息头11个字节定长
 * = 4 // 魔数,magic = (int) 0x12345678
 * + 1 // 版本号,通常情况下时预留字段,用于协议升级的时候用到.
 * + 1 // 序列化算法,如何把Java对象转换二进制数据已经二进制数据如何转换回Java对象
 * + 1 // 指令
 * + 4 // 数据部分的长度,int类型
 * </pre>
 *
 * @author huang.zhangh
 * @version PacketCodec.java, v 0.1 2020-09-28 17:37
 */
public class PacketCodec {
    public static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodec INSTANCE = new PacketCodec();
    // 请求数据包类型
    private final Map<Byte, Class<? extends Packet>> packetTypeMap;
    //序列化方式
    private final Map<Byte, Serializer> serializerMap;

    private PacketCodec() {
        packetTypeMap = new HashMap<>();
        serializerMap = new HashMap<>();

        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
        packetTypeMap.put(LOGOUT_REQUEST, LogoutRequestPacket.class);
        packetTypeMap.put(LOGOUT_RESPONSE, LogoutResponsePacket.class);
        packetTypeMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
        packetTypeMap.put(CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
        packetTypeMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        packetTypeMap.put(JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
        packetTypeMap.put(QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
        packetTypeMap.put(QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
        packetTypeMap.put(LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponsePacket.class);
        packetTypeMap.put(GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
        packetTypeMap.put(GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);
        packetTypeMap.put(HEARTBEAT_REQUEST, HeartBeatRequestPacket.class);
        packetTypeMap.put(HEARTBEAT_RESPONSE, HeartBeatResponsePacket.class);

        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithmEnum(), serializer);
    }

    public void encode(ByteBuf byteBuf, Packet packet) {
        //序列化对象
        byte[] bytes = Serializer.DEFAULT.serializer(packet);
        //编码
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithmEnum());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public Packet decode(ByteBuf byteBuf) {
        //跳过魔法数
        byteBuf.skipBytes(4);
        //跳过版本号
        byteBuf.skipBytes(1);
        //读取序列化算法
        byte serializeAlgorithm = byteBuf.readByte();
        //读取指令
        byte command = byteBuf.readByte();
        //读取数据包长度
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        //获取请求数据包类型
        Class<? extends Packet> requestType = packetTypeMap.get(command);
        Serializer serializer = serializerMap.get(serializeAlgorithm);
        if (requestType != null && serializer != null) {
            return serializer.deserializer(requestType, bytes);
        }
        return null;
    }
}