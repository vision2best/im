/*
 * bianque.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.client.console;


import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author huang.zhangh
 * @version ConsoleCommand.java, v 0.1 2020-09-29 11:18
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}