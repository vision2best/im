/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.response;

import com.youbaaa.im.protocol.Packet;
import com.youbaaa.im.protocol.command.Command;
import lombok.Data;

/**
 * @author huang.zhangh
 * @version MessageResponsePacket.java, v 0.1 2020-09-29 13:50
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return Command.MESSAGE_RESPONSE;
    }
}