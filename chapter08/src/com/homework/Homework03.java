package com.homework;

public class Homework03 {
    public static void main(String[] args) {
        Teacher teacher1 = new Professor("professor", 59, "教授");
        Teacher teacher2 = new AssociateProfessor("Associateprofessor", 38, "副教授");
        Teacher teacher3 = new Lecturer("Lecturer", 24, "讲师");
        System.out.println(teacher1.introduce());
        System.out.println(teacher2.introduce());
        System.out.println(teacher3.introduce());
    }
}

class Teacher {
    String name;
    int age;
    String post;
    static int salary = 1800;

    public Teacher(String name, int age, String post) {
        this.name = name;
        this.age = age;
        this.post = post;
    }

    public String introduce() {
        return "姓名：" + name +
                "年龄：" + age +
                "职称：" + post;
    }
}

class Professor extends Teacher {
    public Professor(String name, int age, String post) {
        super(name, age, post);
    }

    @Override
    public String introduce() {
        return super.introduce() +
                "工资：" + 1.3 * salary;
    }
}

class AssociateProfessor extends Teacher {
    public AssociateProfessor(String name, int age, String post) {
        super(name, age, post);
    }

    @Override
    public String introduce() {
        return super.introduce() +
                "工资：" + 1.2 * salary;
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post) {
        super(name, age, post);
    }

    @Override
    public String introduce() {
        return super.introduce() +
                "工资：" + 1.1 * salary;
    }
}