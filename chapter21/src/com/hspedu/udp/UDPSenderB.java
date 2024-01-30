package com.hspedu.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Solider
 * @version 1.0
 * 发送端
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象，监听9998端口
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        byte[] buf = new String("hello, 明天吃火锅。。。").getBytes();
        // 将数据装包
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);
        // 接收回复的信息
        buf = new byte[1024]; // 规定接收数据报的长度，但是不能超过64k
        datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength(); // 获取数据报的长度
        byte[] data = datagramPacket.getData(); // 获取数据报的数据
        String s = new String(data, 0, length);
        System.out.println(s);
        // 关闭资源
        datagramSocket.close();
        System.out.println("发送端B，退出。。。");
    }
}
