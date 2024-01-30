package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;

import java.util.Scanner;

public class HouseView {
    private boolean loop = true;
    Scanner sc = new Scanner(System.in);
    HouseService houseService = new HouseService(1);
    public void houseMenu() {
        do {
            System.out.println("================房屋出租系统================");
            System.out.println("\t\t1. 新 增 房 源");
            System.out.println("\t\t2. 查 找 房 屋");
            System.out.println("\t\t3. 删 除 房 屋");
            System.out.println("\t\t4. 修 改 房 屋 信 息");
            System.out.println("\t\t5. 房 屋 列 表");
            System.out.println("\t\t6. 退      出");
            System.out.print("请输入(1 ~ 6): ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1 :
                    addHouse();
                    break;
                case 2 :
                    searchHouse();
                    break;
                case 3 :
                    delHouse();
                    break;
                case 4 :
                    reviseHouse();
                    break;
                case 5 :
                    listHouse();
                    break;
                case 6 :
                    System.out.println("退出");
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入...");
                    System.out.print("请输入(1 ~ 6): ");
                    choice = sc.nextInt();
            }
        } while(loop);
    }

    public void addHouse() {
        System.out.println("================添加房屋================");
        System.out.print("姓名：");
        String name = sc.next();
        System.out.print("电话：");
        String phone = sc.next();
        System.out.print("地址：");
        String address = sc.next();
        System.out.print("月租：");
        double rent = sc.nextDouble();
        System.out.print("状态(未出租/已出租)：");
        String state = sc.next();
        House houses = new House(0, name, phone, address, rent, state);
        houseService.add(houses);
    }

    public void searchHouse() {
        System.out.println("================查找房屋================");
        System.out.print("请输入你要查找的id: ");
        int id = sc.nextInt();
        houseService.search(id);
    }

    public void delHouse() {
        System.out.println("请选择是否删除房屋编号(-1退出)： ");
        int id = sc.nextInt();
        System.out.println("确认是否删除(y/n):请小心选择: ");
        System.out.println("请输入你的选择(y/n):");
        String choice = sc.next();
        if (choice.equals("y")) {
            houseService.delete(id);
        }
    }

    public void reviseHouse() {
        System.out.println("请选择修改房屋的编号(-1退出):");
        int id = sc.nextInt();
        System.out.print("姓名：");
        String name = sc.next();
        System.out.print("电话：");
        String phone = sc.next();
        System.out.print("地址：");
        String address = sc.next();
        System.out.print("月租：");
        double rent = sc.nextDouble();
        System.out.print("状态(未出租/已出租)：");
        String state = sc.next();
        House houses = new House(id, name, phone, address, rent, state);
        houseService.revise(houses, id);
    }
    public void listHouse() {
        System.out.println("================房屋列表================");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
        House[] house = houseService.list();
        for (int i = 0; i < house.length; i++) {
            if (house[i] == null) break;
            System.out.println(house[i]);
        }
    }
}
