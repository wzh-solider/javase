package com.hspedu.map;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("NO1", "hsp");
        map.put("NO2", "jack");
        map.put("NO3", "mary");
        System.out.println("map = " + map);
        map.remove("NO2");
        System.out.println("mapRemove = " + map);
        System.out.println("mapGet = " + map.get("NO1"));
        boolean loop = map.isEmpty();
        System.out.println(loop);
        System.out.println("mapSize = " + map.size());
        loop = map.containsKey("NO1");
        System.out.println(loop);
        map.clear();
        System.out.println("mapClearSize = " + map.size());
        System.out.println("mapClearIsEmpty = " + map.isEmpty());
    }
}
