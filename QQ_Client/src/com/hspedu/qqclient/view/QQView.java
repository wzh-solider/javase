package com.hspedu.qqclient.view;

import com.hspedu.qqclient.service.ManageClientService;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;
import com.hspedu.qqcommon.User;


/**
 * @author Solider
 * @version 1.0
 * 客户端的菜单页面
 */
public class QQView {

    private boolean loop = true; // 控制是否显示菜单
    private String key; // 接收用户输入
    private UserClientService userClientService = new UserClientService(); // 验证用户登录注册的属性
    private ManageClientService manageClientService = new ManageClientService(); // 用于客户端消息相关的内容
    // 显示主菜单
    public void mainMenu() {

        while (loop) {
            System.out.println("=============欢迎登录网络通信系统============");
            System.out.println("\t\t1. 登录系统");
            System.out.println("\t\t9. 退出系统");
            System.out.print("请输入你的选择：");
            // 使用Utility工具类中的readString()方法，用来限制用户输入的个数
            key = Utility.readString(1);
            switch (key) {
                case "1" -> {
                    // 用户输入账号、密码
                    System.out.print("请输入账号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String password = Utility.readString(50);
                    // 判断账号、密码是否正确
                    if (userClientService.checkUser(userId, password)) {
                        System.out.println("=============欢迎" + userId + "用户============");
                        // 进入二级菜单
                        secMenu(userId);
                    } else {
                        System.out.println("账号、密码错误！！！");
                    }
                }
                case "9" -> {
                    loop = false;
                    System.out.println("系统退出...");
                    userClientService.exitClientConnectServer();
                }
            }
        }

    }

    // 显示二级菜单
    private void secMenu(String userId) {
        while(loop) {
            System.out.println("=============网络通信系统二级菜单(用户 " + userId + ")============");
            System.out.println("\t\t1. 显示在线用户列表");
            System.out.println("\t\t2. 群发消息");
            System.out.println("\t\t3. 私聊消息");
            System.out.println("\t\t4. 发送文件");
            System.out.println("\t\t9. 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1" -> {
                    // 向服务器发送请求，要求返回用户列表
                    System.out.println("======显示在线用户列表======");
                    // 使用UserClientService，用户服务类中的onlineFriendList()方法
                    userClientService.onlineFriendList();
                    sleep();
                }
                case "2" -> {
                    System.out.println("======群发======");
                    System.out.print("请输入发送内容：");
                    String content = Utility.readString(100);
                    manageClientService.groupChat(userId, content);
                    sleep();
                }
                case "3" -> {
                    System.out.println("======私聊======");
                    System.out.print("请输入发送的对象：");
                    String getter = Utility.readString(50);
                    System.out.print("请输入发送的内容：");
                    String content = Utility.readString(100);
                    manageClientService.privateChat(userId, getter, content);
                    sleep();
                }
                case "4" -> {
                    System.out.println("======发送文件======");
                    System.out.print("请输入发送对象：");
                    String getter = Utility.readString(50);
                    System.out.print("请输入发送文件的完整路径：");
                    String senderFilePath = Utility.readString(100);
                    System.out.print("请输入发送文件到对方的路径：");
                    String getterFilePath = Utility.readString(100);
                    manageClientService.sendFile(userId, getter, senderFilePath, getterFilePath);
                    sleep();
                }
                case "9" -> {
                    System.out.println("退出二级系统");
                    return;
                }
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
