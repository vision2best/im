/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.common.utils;

import java.util.UUID;

/**
 * @author huang.zhangh
 * @version UserIDUtil.java, v 0.1 2020-09-29 14:07
 */
public class UserIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}