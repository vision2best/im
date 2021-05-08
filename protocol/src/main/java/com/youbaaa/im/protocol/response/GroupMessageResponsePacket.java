package com.youbaaa.im.protocol.response;

import com.youbaaa.im.common.session.Session;
import com.youbaaa.im.protocol.Packet;
import lombok.Data;

import static com.youbaaa.im.protocol.command.Command.GROUP_MESSAGE_RESPONSE;


@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
