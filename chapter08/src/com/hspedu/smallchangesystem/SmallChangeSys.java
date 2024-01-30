package com.hspedu.smallchangesystem;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String details = "-----------零钱通明细-----------";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        double money = 0;
        double balance = 0;
        double spend = 0;
        do {
            System.out.println("\n-----------零钱通菜单-----------");
            System.out.println("1. 零钱通明细");
            System.out.println("2. 收益入账");
            System.out.println("3. 消费");
            System.out.println("4. 退出");
            System.out.print("请选择(1 ~ 4):");
            String math = scanner.next();
            switch(math) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("-----------收益入账-----------");
                    System.out.print("收益入账：");
                    money = scanner.nextDouble();
                    balance += money;
                    date = new Date();
                    details += "\n" + "收益入账 +" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "3":
                    System.out.println("-----------消费-----------");
                    System.out.print("消费：");
                    money = scanner.nextDouble();
                    if(money > balance) {
                        System.out.println("余额不足");
                    } else {
                    balance -= money;
                    date = new Date();
                    details += "\n" + "消费 -" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                    }
                case "4":
                    String choice = "";
                    while(true) {
                        System.out.println("你确定要退出吗？(y / n)");
                        choice = scanner.next();
                        if ("y".equals(choice)) {
                            System.out.println("退出零钱通......");
                            loop = false;
                            break;
                        } else if ("n".equals(choice)) {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入:");math = scanner.next();
            }

        } while(loop);
    }
}

