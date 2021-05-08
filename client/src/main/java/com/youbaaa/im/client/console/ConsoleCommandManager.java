/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.client.console;


import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.youbaaa.im.client.command.ConsoleCommandEnum.*;

/**
 * @author huang.zhangh
 * @version ConsoleCommandManager.java, v 0.1 2020-09-29 11:19
 */
public class ConsoleCommandManager implements ConsoleCommand {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put(SEND_TO_USER, new SendToUserConsoleCommand());
        consoleCommandMap.put(LOGOUT, new LogoutConsoleCommand());
        consoleCommandMap.put(CREATE_GROUP, new CreateGroupConsoleCommand());
        consoleCommandMap.put(JOIN_GROUP, new JoinGroupConsoleCommand());
        consoleCommandMap.put(QUIT_GROUP, new QuitGroupConsoleCommand());
        consoleCommandMap.put(LIST_GROUP_MEMBERS, new ListGroupMembersConsoleCommand());
        consoleCommandMap.put(SEND_TO_GROUP, new SendToGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String command = scanner.next();
        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}