package com.hspedu.socket.tcpfilecopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * @author Solider
 * @version 1.0
 * 客户端
 */
public class TCPFileCopyClient {
    public static void main(String[] args) throws IOException {
        // 向服务端发送连接请求
        Socket socket = new Socket(InetAddress.getByName("192.168.43.92"), 9999);
        System.out.println("客户端连接成功！！！");
        // 连接成功后，向服务端发送图片
        String filePath = "D:\\qie.png";
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = fileInputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, readLen);
        }
        // 设置结束标志
        socket.shutdownOutput();
        // 关闭
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
