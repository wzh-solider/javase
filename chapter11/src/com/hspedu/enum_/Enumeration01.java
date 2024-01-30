package com.hspedu.enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        // System.out.println(Season.AUTUMN);
        System.out.println(Season.INNER);
    }
}

class Season {
//    SPRING("春天", "温暖"),
//    SUMMER("夏天", "炎热"),
//    AUTUMN("秋天", "凉爽"),
//    WINTER("冬天", "寒冷");
    private String name;
    private String desc;

    public static final Season INNER = new Season("jain", "jian");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

