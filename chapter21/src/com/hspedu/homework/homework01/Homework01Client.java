package com.hspedu.homework.homework01;

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
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        // 创建socket对象，发送连接请求
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端，连接成功！！！");
        // 连接成功后，向数据通道中写入需要向服务端发送的数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        System.out.print("请输入需要发送的内容：");
        bufferedWriter.write(new Scanner(System.in).nextLine());
        // 刷新字符流
        bufferedWriter.flush();
        // 设置结束标志
        socket.shutdownOutput();
        // 发送完成后，接收服务端回复的信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // 关闭对象
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
