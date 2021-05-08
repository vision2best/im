/*
 * bianque.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.youbaaa.im.common.serializer;


import com.youbaaa.im.common.serializer.impl.JSONSerializer;

/**
 * @author huang.zhangh
 * @version Serializer.java, v 0.1 2020-09-28 17:50
 */
public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlgorithmEnum();

    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    byte[] serializer(Object obj);

    /**
     * 反序列化
     *
     * @param tClass
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserializer(Class<T> tClass, byte[] bytes);
}