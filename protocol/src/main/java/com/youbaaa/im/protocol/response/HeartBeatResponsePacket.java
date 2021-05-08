package com.youbaaa.im.protocol.response;


import com.youbaaa.im.protocol.Packet;

import static com.youbaaa.im.protocol.command.Command.HEARTBEAT_RESPONSE;


public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
