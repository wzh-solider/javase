package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Solider
 * @version 1.0
 * 演示InetAddress的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        // 通过InetAddress类的getLocalHost()方法，获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("getHostAddress()方法，获取本机的地址：" + localHost.getHostAddress());
        System.out.println("getHostName()方法，获取本机的名字：" + localHost.getHostName());

        // 通过getByName()方法，指定(主机名 / 域名)获取一个对象
        InetAddress byName = InetAddress.getByName("www.solider.top");
        System.out.println(byName);
    }
}
