package com.hspedu.extend_;

public class extends_thisDetail {
    public static void main(String[] args) {
        Son_ son_ = new Son_();
        System.out.println(son_.show());
    }
}

class Grandfuther {
    String name = "爷爷";
    int age = 100;
}

class Father_ extends Grandfuther {
    String name = "爸爸";
    String hobby = "旅游";
}

class Son_ extends Father_ {
    String name = "儿子";
    double score = 23.4;
    public int show() {
        return super.age;
    }
}

