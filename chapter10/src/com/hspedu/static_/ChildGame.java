package com.hspedu.static_;

public class ChildGame {
    public static void main(String[] args) {
        Child child = new Child("白骨精");
        Child child1 = new Child("孙悟空");
        child1.child();
    }
}

class Child {
    private String name;
    private static int count = 0;

    public Child(String name) {
        this.name = name;
        System.out.println(name + "加入了游戏");
        count++;
    }

    public void child() {
        System.out.println("共有" + count + "名孩子加入了游戏");
    }
}
