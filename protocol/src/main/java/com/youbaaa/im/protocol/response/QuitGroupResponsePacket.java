package com.youbaaa.im.protocol.response;

import com.youbaaa.im.protocol.Packet;
import lombok.Data;

import static com.youbaaa.im.protocol.command.Command.QUIT_GROUP_RESPONSE;


@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_RESPONSE;
    }
}
