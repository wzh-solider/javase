package com.hspedu.homework.homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Solider
 * @version 1.0
 * 客户端
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        // 客户端，请求连接服务端的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接成功！！！");
        // 连接成功后，向服务端发送要求
        OutputStream outputStream = socket.getOutputStream();
        System.out.print("请输入需要的文件：");
        String name = new Scanner(System.in).next();
        outputStream.write(name.getBytes());
        // 设置结束标志
        socket.shutdownOutput();
        // 接收服务端回发的文件
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String filePath = "E:\\" + name + ".mp3";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        // 关闭流
        bufferedOutputStream.close();
        // 关闭对象
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("文件下载完成！！！");
    }
}
