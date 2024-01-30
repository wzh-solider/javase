package com.hspedu.ploy_.ployexercise;

public class PloyExercise02 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count);
        sub.display();
        Base base = sub;
        System.out.println(sub == base);
        System.out.println(base.count);
        base.display();
    }
}

class Base {
    int count = 10;
    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}