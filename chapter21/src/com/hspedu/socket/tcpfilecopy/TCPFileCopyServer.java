package com.hspedu.socket.tcpfilecopy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 服务端
 */
public class TCPFileCopyServer {
    public static void main(String[] args) throws IOException {
        // 服务端监听9999端口，等待客户端的连接。。。
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端监听9999端口，等待客户端连接。。。");
        // 监听客户端连接请求
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功！！！");
        // 接收由客户端发送的图片
        String filePath = "src\\qie.png";
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = new FileOutputStream(filePath);
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, readLen);
        }
        // 关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
