package com.hspedu.qqServer.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Solider
 * @version 1.0
 * 保持服务端向某个客户端的联系
 */
public class ServerConnectClientThread extends Thread {
    // 持有一个socket对象
    private Socket socket;
    // 连接到服务端的用户id
    private String userId;
    // 创建一个ArrayList集合，用来管理离线用户的message
    ArrayList<Message> messageArrayList = new ArrayList<>();
    // 设置线程退出的变量
    private boolean loop = true;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    @Override
    public void run() {
        // 循环读取客户端的信息
        while (loop) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通讯，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // 判断从客户端传送的message类型
                switch (message.getMessageType()) {
                    case MessageType.MESSAGE_GET_ONLINE_FRIEND -> {
                        Message message1 = new Message();
                        System.out.println("======" + message.getSender() + "请求拉取在线用户列表======");
                        // 设置返回信息的接收者
                        message1.setGetter(message.getSender());
                        // 设置返回信息的内容
                        message1.setContent(ManageServerConnectClientThread.getOnlineUser());
                        // 设置返回信息的类型
                        message1.setMessageType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                        // 写入数据通道
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(message1);
                    }
                    case MessageType.MESSAGE_COMM_MES, MessageType.MESSAGE_FILE_MES -> {
                        if (ManageServerConnectClientThread.onlineUserExists(message.getGetter())) {
                            ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                            oos.writeObject(message);
                        } else {
                            messageArrayList.add(message);
                            QQServer.offlineDB.put(message.getGetter(), messageArrayList);
                        }
                    }
                    case MessageType.MESSAGE_ALL_MES -> {
                        // 循环遍历
                        HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThread.getHashMap();
                        Iterator<String> it = hashMap.keySet().iterator();
                        while (it.hasNext()) {
                            String key =  it.next();
                            if (!message.getSender().equals(key)) {
                                ObjectOutputStream oos = new ObjectOutputStream(hashMap.get(key).getSocket().getOutputStream());
                                oos.writeObject(message);
                            }
                        }
                    }
                    case MessageType.MESSAGE_CLIENT_EXIT -> {
                        System.out.println(message.getSender() + "客户端退出");
                        // 将此线程从集合中删除
                        ManageServerConnectClientThread.deleteUserClient(message.getSender());
                        // 关闭线程
                        loop = false;
                        // 关闭此线程所持有的socket对象
                        socket.close();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUserId() {
        return userId;
    }
}
