package com.hspedu.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Solider
 * @version 1.0
 * 接收端
 */
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象，监听8888端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        // 创建一个DatagramPacket对象，接收发送端打包的数据报
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("等待发送端发送信息");
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        // 根据不同情况，回复不同消息
        if (s.equals("四大名著是那些")) {
            buf = "四大名著是<<红楼梦>>...".getBytes();
        } else {
            buf = "what？".getBytes();
        }
        datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 9998);
        datagramSocket.send(datagramPacket);
        // 关闭
        datagramSocket.close();
        System.out.println("接收端程序退出。。。");
    }
}
