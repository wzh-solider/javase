package com.hspedu.homework.homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 服务端
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        // 服务端监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        // 等待客户端的连接，连接成功后，返回给客户端socket对象
        System.out.println("监听9999端口，等待客户端的连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功！！！");
        // 连接成功后，接收客户端发送的指定文件
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        // 判断在服务端此音乐是否存在，存在即返回，不存在返回默认音乐
        String fileName = "D:\\" + s + ".mp3";
        File file = new File(fileName);
        if (!file.exists()) {
            fileName = "D:\\花之舞 - 纯音乐网.mp3";
            file = new File(fileName);
        }
        // 将指定音乐传送到客户端
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // 关闭流
        bufferedInputStream.close();
        // 向数据通道中写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        // 设置结束标志
        socket.shutdownOutput();
        // 关闭
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
