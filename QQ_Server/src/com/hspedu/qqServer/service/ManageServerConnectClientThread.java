package com.hspedu.qqServer.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Solider
 * @version 1.0
 * 管理服务端向客户端连接的线程
 */
public class ManageServerConnectClientThread {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<>();

    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        // 将线程加入集合，key = 发送者的用户id
        hashMap.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hashMap.get(userId);
    }

    // 获取在线用户
    public static String getOnlineUser() {
        // 循环遍历集合
        Iterator it = hashMap.keySet().iterator();
        StringBuilder onlineUser = new StringBuilder();
        while (it.hasNext()) {
            onlineUser.append(it.next().toString()).append(" ");
        }
        return onlineUser.toString();
    }

    // 遍历在线用户
    public static boolean onlineUserExists(String getter) {
        // 循环遍历集合
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String onlineUser =  it.next();
            if (onlineUser.equals(getter)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteUserClient(String userId) {
        hashMap.remove(userId);
    }

    public static HashMap<String, ServerConnectClientThread> getHashMap() {
        return hashMap;
    }
}
