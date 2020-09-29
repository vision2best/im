package com.youbaaa.im.protocol.response;

import com.youbaaa.im.protocol.Packet;
import com.youbaaa.im.session.Session;
import lombok.Data;

import java.util.List;

import static com.youbaaa.im.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;


@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
