package com.hspedu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 客户端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        // 1. 连接服务端(ip, 端口号)
        // 通过socket,请求连接服务端 ip 的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端成功连接");
        // 2. 连接成功后，向数据通道写入数据
        String str = "服务端读取到文件";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(str.getBytes());
        outputStream.close();
        socket.close();
        System.out.println("连接中断，客户端退出。。。");
    }
}
