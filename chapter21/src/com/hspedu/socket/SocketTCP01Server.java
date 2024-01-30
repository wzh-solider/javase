package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // 1. 在本机的 9999 端口监听，等待连接(要求，不能本机没有占用9999端口监听)
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在监听9999端口，等待客户端的连接。。。");
        // 2. 当没有客户端连接9999端口时，程序会阻塞，等待连接。。。
        // 如果有客户端连接，则会返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("客户端成功连接");
        // 3. 连接成功后，从数据通道中读取文件
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("连接中断，服务端退出。。。");
    }
}
