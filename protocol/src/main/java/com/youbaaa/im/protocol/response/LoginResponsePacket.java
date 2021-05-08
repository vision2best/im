/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.response;

import com.youbaaa.im.protocol.Packet;
import lombok.Data;

import static com.youbaaa.im.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author huang.zhangh
 * @version LoginResponsePacket.java, v 0.1 2020-09-29 09:32
 */
@Data
public class LoginResponsePacket extends Packet {
    private String userId;
    private String userName;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}