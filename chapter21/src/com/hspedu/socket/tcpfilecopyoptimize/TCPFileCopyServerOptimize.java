package com.hspedu.socket.tcpfilecopyoptimize;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 */
public class TCPFileCopyServerOptimize {
    public static void main(String[] args) throws Exception {
        // 服务端监听8888端口，等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("监听8888端口，等待客户端连接...");
        // 接收客户端的连接请求，并向客户端返回一个socket对象
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功！！！");
        // 连接成功后，接收数据通道中由客户端发送的图片数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // 下载图片，写入到"src\\qie.png"
        String download = "src\\qie.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(download));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        // 下载完成后，向客户端发送已接收
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("已经收到图片");
        // 字符流，刷新
        bufferedWriter.flush();
        // 设置结束标志
        socket.shutdownOutput();
        // 关闭

        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
