package com.hspedu.extend_;

public class ExtendsTheory {
    public static void main(String[] args) {
        // 继承本质和规则
        Son son = new Son();
        // 1. 首先在方法区，会将类从顶级父类(Object)开始，到最终new Son()的类全部加载，并进行继承关系构建
        // 2. 接着在内存堆中开辟空间，加载属性
        // 3. 最后对象son，指向开辟的空间

        // -> 按查找关系来返回信息
        // 1. 首先查看子类是否含有该属性，有且可以访问则返回该属性
        // 2. 没有则向上查找父类，直到Object(顶级父类)
        System.out.println(son.name); // 在子类son中含有name属性，则返回 儿子
        System.out.println(son.age); // son中没有age属性，向上查找父类Father含有age属性，返回 46
        System.out.println(son.hobby); // 在Grandpa类中才有hobby属性，返回 旅游
    }
}

class Grandpa {
    String name = "爷爷";
    String hobby = "旅游";
}

class Father extends Grandpa {
    String name = "爸爸";
    int age = 46;
}

class Son extends Father {
    String name = "儿子";
}


