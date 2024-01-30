package com.hspedu.homework;

import java.util.*;

public class Homework03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);
        hashMap.replace("jack", 650, 3000);
        //hashMap.put("jack", 2600);
        System.out.println("修改后的hashMap = " + hashMap);
        Set entrySet = hashMap.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            Map.Entry entry = (Map.Entry) next;
            entry.setValue((Integer)entry.getValue() + Integer.valueOf(100));
        }
        System.out.println("增加后的hashMap = " + hashMap);
        // 通过查找key，匹配出value
        Set key = hashMap.keySet();
        // 1. 迭代器
        it = key.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next + "-" + hashMap.get(next));
        }
        // 2. 增强for
        for (Object o : key) {
            System.out.println(o + "-" + hashMap.get(o));
        }

        System.out.println("==========");
        // 直接遍历所有的工资value
        Collection value = hashMap.values();
        // 1. 迭代器
        it = value.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next);
        }
        // 2. 增强for
        for (Object o : value) {
            System.out.println(o);
        }

        System.out.println("==========");
        // 通过entrySet实现遍历
        Set entrySet1 = hashMap.entrySet();
        // 1. 迭代器
        it = entrySet1.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        // 2. 增强for循环
        for (Object o : entrySet1) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}


