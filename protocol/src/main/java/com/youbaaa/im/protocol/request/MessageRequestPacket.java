/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.request;

import com.youbaaa.im.protocol.Packet;
import lombok.Data;

import static com.youbaaa.im.protocol.command.Command.MESSAGE_REQUEST;

/**
 * @author huang.zhangh
 * @version MessageRequestPacket.java, v 0.1 2020-09-29 13:51
 */
@Data
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;
    private String fromUserId;
    private String fromUserName;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    public MessageRequestPacket(String toUserId, String message, String fromUserId, String fromUserName) {
        this.toUserId = toUserId;
        this.message = message;
        this.fromUserId = fromUserId;
        this.fromUserName = fromUserName;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}