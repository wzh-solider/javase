package com.hspedu.homework.homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 服务端
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket对象，用来监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("监听9999端口，等待客户端的连接。。。");
        Socket socket = serverSocket.accept();
        System.out.println("客户端，连接成功！！！");
        // 连接成功后，读取数据通道中由客户端发送的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        // 判断客户端的发送信息，回复相应的内容
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        switch (sb.toString()) {
            case "name" -> {
                bufferedWriter.write("我是人工智能ChatGPT-4.0");
            }
            case "hobby" -> {
                bufferedWriter.write("编写java程序");
            }
            default -> {
                bufferedWriter.write("你说啥呢");
            }
        }
        // 刷新字符流
        bufferedWriter.flush();
        // 设置结束标志
        socket.shutdownOutput();
        // 关闭对象
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
