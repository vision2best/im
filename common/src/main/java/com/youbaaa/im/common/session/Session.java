/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.common.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huang.zhangh
 * @version Session.java, v 0.1 2020-09-29 11:24
 */
@Data
@NoArgsConstructor
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }

}