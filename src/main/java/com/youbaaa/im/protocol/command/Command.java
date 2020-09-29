/*
 * bianque.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.protocol.command;

/**
 * @author huang.zhangh
 * @version Command.java, v 0.1 2020-09-29 09:27
 */
public interface Command {
    //登录请求
    Byte LOGIN_REQUEST = 1;
    //登录响应
    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}