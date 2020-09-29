/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.request;

import com.youbaaa.im.protocol.Packet;
import lombok.Data;
import static com.youbaaa.im.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author huang.zhangh
 * @version LoginRequestPacket.java, v 0.1 2020-09-29 09:29
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userName;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}