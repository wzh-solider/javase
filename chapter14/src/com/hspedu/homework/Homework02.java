package com.hspedu.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Homework02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        List list = new ArrayList();
        list.add(car1);
        list.add(car2);
        // 判断集合是否为空
        boolean loop = list.isEmpty();
        System.out.println("集合是否为空：" + loop);
        // 判断集合中的元素个数
        int n = list.size();
        System.out.println("集合中的元素个数为：" + n);
        // 查找集合中的元素
        System.out.println("查找集合中是否含有宝马：" + list.contains(car1));
        // 删除指定的元素，返回被删除的Object类型
        Car removeCar = (Car)list.remove(0);
        System.out.println("list = " + list);
        // 修改，返回被修改元素的Object类型
        Car setCar = (Car)list.set(0, car1);
        System.out.println("修改后的list集合为：" + list);
        // 清空
        list.clear();
        loop = list.isEmpty();
        System.out.println("被清空后的集合是否为空：" + loop);
        // 添加，删除，查找多个元素
        List newList = new ArrayList();
        Car car3 = new Car("奔驰", 300000);
        Car car4 = new Car("保时捷", 40000000);
        newList.add(car3);
        newList.add(car4);
        System.out.println("newList = " + newList);
        // 添加
        list.addAll(newList);
        System.out.println("list = " + list);
        // 删除
        list.removeAll(newList);
        System.out.println("removeAllList = " + list);
        // 查找
        loop = list.containsAll(newList);
        System.out.println("newList是否存在：" + loop);

        // 遍历所有元素
        // 1. 迭代器遍历
        list.addAll(newList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.print(next + " ");
        }
        System.out.println();
        // 2. 普通for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        // 3. 增强for循环遍历
        for(Object o : list) {
            System.out.print(o + " ");
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}