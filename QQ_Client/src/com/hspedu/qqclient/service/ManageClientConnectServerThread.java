package com.hspedu.qqclient.service;

import java.util.HashMap;

/**
 * @author Solider
 * @version 1.0
 * 管理客户端连接服务端的线程
 */
public class ManageClientConnectServerThread {
    // 通过hashMap集合管理连接线程
    private static HashMap<String, ClientConnectServerThread> hashMap = new HashMap<>();

    // 向集合中加入线程
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hashMap.put(userId, clientConnectServerThread);
    }

    // 通过userId获取对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hashMap.get(userId);
    }
}
