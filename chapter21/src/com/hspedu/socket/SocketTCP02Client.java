package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        // 1. 发送请求，接收一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接成功");
        // 2. 连接成功后，向数据通道中，写入数据
        String send = "hello, server";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(send.getBytes());
        // 3. 通知服务端，我的数据已经输入完毕
        socket.shutdownOutput();
        // 4. 读取数据管道中，由服务端发送的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }
        // 关闭对象
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
