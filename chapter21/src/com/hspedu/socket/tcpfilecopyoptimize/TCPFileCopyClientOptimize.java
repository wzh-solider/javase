package com.hspedu.socket.tcpfilecopyoptimize;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Solider
 * @version 1.0
 */
public class TCPFileCopyClientOptimize {
    public static void main(String[] args) throws Exception {
        // 向服务端请求连接，接收服务端返回的socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端连接成功！！！");
        // 向服务端发送图片
        String imgPath = "D:\\qie.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(imgPath));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        // 向数据通道中写入数据
        bufferedOutputStream.write(bytes);
        // 设置结束标志
        socket.shutdownOutput();
        // 接收由服务端回复的信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(readLine);
        }
        // 关闭
        bufferedReader.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}
