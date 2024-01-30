package com.hspedu.map.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("tom", "韩顺平");
        System.out.println(treeMap);
    }
}
