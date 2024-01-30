package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * TCP字符流编程，服务端
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        // 服务端监听9999端口，等待客户端的连接
        ServerSocket serverSocket = new ServerSocket(9999);
        // 监听客户端连接请求
        Socket accept = serverSocket.accept();
        System.out.println("客户端，连接成功");
        // 从数据通道中读出由客户端发送的数据
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }
        // 向客户端发送数据
        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String str = "hello, client";
        bufferedWriter.write(str);
        accept.shutdownOutput();
        // 使用字符流，需要手动进行刷新，不然就写不到数据通道里面中
        bufferedWriter.flush();
        // 关闭对象
        accept.close();
        serverSocket.close();
        bufferedReader.close();
        bufferedWriter.close();

    }
}
