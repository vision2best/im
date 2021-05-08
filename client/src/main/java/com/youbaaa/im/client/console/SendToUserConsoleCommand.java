package com.youbaaa.im.client.console;

import com.youbaaa.im.common.session.Session;
import com.youbaaa.im.common.utils.SessionUtil;
import com.youbaaa.im.protocol.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个用户：");
        Session session = SessionUtil.getSession(channel);
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message, session.getUserId(), session.getUserName()));
    }
}
