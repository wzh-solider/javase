package com.hspedu.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat single = Cat.getCat("小黄");
        System.out.println(single);
    }
}

class Cat {
    private String name;

    private static Cat cat;

    private Cat(String name) {
        this.name = name;
    }

    public static Cat getCat(String name) {
        if (cat == null) {
            cat = new Cat(name);
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
