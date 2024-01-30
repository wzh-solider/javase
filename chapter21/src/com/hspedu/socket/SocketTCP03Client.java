package com.hspedu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Solider
 * @version 1.0
 * TCP字符流编程，客户端
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        // 请求连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("服务端连接成功。。。");
        // 向服务端发送文件
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String send = "hello, server";
        bufferedWriter.write(send);
        // 设置结束标志
        socket.shutdownOutput();
        // 手动刷新IO流
        bufferedWriter.flush();
        // 接收服务端的文件
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }
        // 关闭对象
        socket.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
