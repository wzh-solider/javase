package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Solider
 * @version 1.0
 * 接收端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramSocket对象，用来监听9999端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        // 接收数据报
        byte[] buf = new byte[1024]; // 规定接收数据报的长度，但是不能超过64k
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("接收端，等待数据的接收。。。");
        datagramSocket.receive(datagramPacket);
        // 读取数据，拆包
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        // 接收到信息后，回复
        byte[] bytes = new String("好的，明天见。。。").getBytes();
        datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9998);
        datagramSocket.send(datagramPacket);
        // 关闭资源
        datagramSocket.close();
        System.out.println("接收端A，退出。。。");
    }
}
