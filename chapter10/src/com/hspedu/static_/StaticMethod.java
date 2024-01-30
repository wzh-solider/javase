package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Student student = new Student("jack", 1000);
        Student student2 = new Student("mark", 1000);
        System.out.println(Student.getTotalFree());
    }
}

class Student {
    private String name;
    public static double totalFree = 0.0;

    public Student(String name, double totalFree) {
        this.name = name;
        this.totalFree += totalFree;
    }

    public static double getTotalFree() {
        return totalFree;
    }
}
