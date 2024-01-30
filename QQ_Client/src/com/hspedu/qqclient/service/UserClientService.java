package com.hspedu.qqclient.service;

import com.hspedu.qqclient.utils.Utility;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 验证用户登录验证、用户注册...
 */
public class UserClientService {
    private User user = new User();
    private Socket socket;
    private ClientConnectServerThread clientConnectServerThread;

    public boolean checkUser(String userId, String password) {
        boolean loop = false;
        // 设置user对象的账号、密码
        user.setUserId(userId);
        user.setPassword(password);

        try {
            // 将user对象，发送给服务端
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);
            // 服务端，返回一个Message对象，用来验证
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)ois.readObject();
            // 判断从服务端返回Message兑现的信息类型
            if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                // 创建一个 ClientConnectServerThread线程类，保持两端的连接
                clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.setName(user.getUserId());

                clientConnectServerThread.start();
                // 此线程开启后，放入ManageClientConnectServerThread类中进行管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                // 如果登录成功，且线程成功启动，将loop置为真，返回
                loop = true;
            } else {
                // 如果登录失败，就关闭socket对象
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return loop;
    }

    // 用来向服务器发送请求返回在线用户列表
    public void onlineFriendList() {

        try {
            // 声明一个message对象，并将其类型设置为MESSAGE_GET_ONLINE_FRIEND
            Message message = new Message();
            // 设置消息的发送者
            message.setSender(user.getUserId());
            // 设置消息的类型
            message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
            // 获取当前线程的socket对象，用于将信息发送给服务端
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId()).getSocket().getOutputStream());
            // 发送消息对象
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 声明退出客户端的方法
    public void exitClientConnectServer() {
        try {
            // 向服务端发送请求退出连接的请求
            Message message = new Message();
            // 设置发送方、信息类型
            message.setSender(user.getUserId());
            message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(user.getUserId() + "用户退出");
            // 退出主线程程序
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
