package com.hspedu.qqServer.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Solider
 * @version 1.0
 * 服务器，监听9999端口，等待客户端的连接，并且保持通讯
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    // 创建一个HashMap集合，用来规定合法的用户 valid(合法的)
    // 也可以创建一个ConcurrentHashMap，可以处理并发的集合
    static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    // 设置离线集合，保存离线用户信息
    static ConcurrentHashMap<String, ArrayList<Message>> offlineDB = new ConcurrentHashMap<>();

    // 初始化合法用户
    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
    }

    public QQServer() {
        try {
            System.out.println("监听9999端口，等待客户端的连接");
            serverSocket = new ServerSocket(9999);
            // 开启服务器推送线程
            new Thread(new SendNewsToAllService()).start();
            // 循环监听9999端口
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("连接成功！！！");
                // 读取user对象
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                Message message = new Message();
                // 判断请求的user对象，是否在要求内
                if (checkUser(user.getUserId(), user.getPassword())) {
                    System.out.println("欢迎用户" + user.getUserId() + "登录成功");
                    // 将需要返回的messageType属性，置为登录成功
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 将message信息返回给客户端
                    oos.writeObject(message);
                    // 因为需要先将登陆成功的消息返回给客户端，所以发送消息的内容需在其后
                    checkOffLineUser(user.getUserId(), socket); // 如果登陆的用户有离线消息，将其发送
                    // 创建线程建立与客户端的联系
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getUserId(), socket);
                    serverConnectClientThread.start();
                    // 将此线程加入到线程管理类中
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), serverConnectClientThread);
                } else {
                    System.out.println("用户：" + user.getUserId() + "  密码：" + user.getPassword() + "验证失败");
                    // 置为登录失败
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    // 返回message对象
                    oos.writeObject(message);
                    // 关闭socket对象
                    socket.close();
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // 如果退出了循环，则不再监听9999端口，关闭ServerSocket对象
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean checkUser(String userId, String password) {
        User user = validUsers.get(userId);
        if (user == null) { // 如果没有寻找到，则证明不合法
            return false;
        }
        if (!user.getPassword().equals(password)) { // 如果有相同的账户，但是密码不同，同样不合法
            return false;
        }
        return true;
    }

    public void checkOffLineUser(String userId, Socket socket) {
        // 循环遍历离线集合
        for (String offlineId : offlineDB.keySet()) {
            if (userId.equals(offlineId)) {
                try {
                    for (Message message : offlineDB.get(offlineId)) {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // 并且将此对象从集合中删除
                offlineDB.remove(offlineId);
            }
        }
    }
}
