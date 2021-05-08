package com.youbaaa.im.protocol.request;

import com.youbaaa.im.protocol.Packet;
import lombok.Data;

import static com.youbaaa.im.protocol.command.Command.JOIN_GROUP_REQUEST;


@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
