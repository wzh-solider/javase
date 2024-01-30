package com.hspedu.map;

import com.sun.source.tree.YieldTree;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("NO1", "hsp");
        map.put("NO2", "jack");
        map.put("NO3", "mary");
        map.put("NO4", "mark");

        // 一、先取出键（key），再通过键（key）去匹配出值（value）
        // 键（key）的类型是 Set 类型
        Set keySet = map.keySet();
        // 1. 增强 for 循环
        System.out.println("----增强for----");
        for (Object key : keySet) {
            // 值（value）是 collection 类型
            System.out.println(key + "-" + map.get(key));
        }
        // 2. 迭代器 Iterator
        System.out.println("---- Iterator ----");
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next + "-" + map.get(next));
        }

        // 二、直接通过 HashMap 中的方法，来取出所有的值（value）
        System.out.println("---- values()方法取出所有value ----");
        System.out.println(map.values());
        Collection values = map.values();
        // 因为 values 是 Collection 集合类型，所以可以使用所有的遍历方式
        // 1. 增强for
        // 2. 迭代器

        // 三、通过 EntrySet 来获取 k-v
        // 1. 增强for
        System.out.println("---- 使用 EntrySet 增强for遍历 ----");
        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        // 2. 迭代器 Iterator
        System.out.println("---- Iterator ----");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
