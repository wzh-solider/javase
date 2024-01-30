package com.hspedu.homework.homework02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author Solider
 * @version 1.0
 * 发送端
 */
//@SuppressWarnings({"all"})
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象，监听9998端口
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        // 创建一个DatagramPacket对象，将数据包装为数据报发送
        System.out.print("请输入：");
        byte[] buf = new Scanner(System.in).nextLine().getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(datagramPacket);
        // 接收，接收端回复的信息
        buf = new byte[1024];
        datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        // 关闭
        datagramSocket.close();
        System.out.println("发送端程序退出。。。");
    }
}
