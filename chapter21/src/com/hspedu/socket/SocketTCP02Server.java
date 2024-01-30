package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        // 1. 服务端，监听9999端口，等待客户端的连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，监听9999端口，等待连接。。。");
        // 2. 接收客户端发来的连接请求，并返回一个socket对象
        Socket socket = serverSocket.accept();
        // 3. 连接成功后，读取通道中由客户端写入的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }
        // 4. 向数据管道中，写入数据，传送给连接的客户端
        OutputStream outputStream = socket.getOutputStream();
        String send = "hello, client";
        outputStream.write(send.getBytes());
        // 5. 通知客户端，我的数据已经结束
        socket.shutdownOutput();
        // 关闭所有对象
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
