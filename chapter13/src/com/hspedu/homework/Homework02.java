package com.hspedu.homework;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Index index = new Index();
        index.login();
        System.out.println("登录成功");
    }
}

class Index {

    Scanner scanner = new Scanner(System.in);

    public void login() {
        System.out.print("请输入用户名：");
        String username = scanner.next();
        module.username(username);
        System.out.print("请输入密码：");
        String password = scanner.next();
        module.password(password);
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        module.email(email);
    }
}

class module {
    public static void username(String username) {
        if (username == null) throw new RuntimeException("用户名不能为空");
        if (username.length() < 2 || username.length() > 4) {
            throw new RuntimeException("用户名长度错误");
        }
    }

    public static void password(String password) {
        char[] chars = password.toCharArray();
        if (password == null) throw new RuntimeException("密码不能为空");
        for (int i = 0; i < chars.length; i++) {
            if (!(Character.isDigit(chars[i]))) {
                throw new RuntimeException("密码格式错误");
            }
        }
    }

    public static void email(String email) {
        if ((email.contains("@") || email.contains(".")) && email.indexOf("@") > email.indexOf(".")) {
            throw new RuntimeException("邮箱格式错误");
        }
    }
}
