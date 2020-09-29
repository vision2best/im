/*
 * bianque.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.attribute;

import com.youbaaa.im.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author huang.zhangh
 * @version Attributes.java, v 0.1 2020-09-29 11:25
 */
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}