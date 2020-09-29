package com.youbaaa.im.protocol.request;


import com.youbaaa.im.protocol.Packet;

import static com.youbaaa.im.protocol.command.Command.HEARTBEAT_REQUEST;


public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
