/*
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.common.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youbaaa.im.common.serializer.Serializer;
import com.youbaaa.im.common.serializer.SerializerAlgorithmEnum;


/**
 * @author huang.zhangh
 * @version JSONSerializer.java, v 0.1 2020-09-28 17:57
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithmEnum() {
        return SerializerAlgorithmEnum.JSON;
    }

    @Override
    public byte[] serializer(Object obj) {
        return JSONObject.toJSONBytes(obj);
    }

    @Override
    public <T> T deserializer(Class<T> tClass, byte[] bytes) {
        return JSON.parseObject(bytes, tClass);
    }
}