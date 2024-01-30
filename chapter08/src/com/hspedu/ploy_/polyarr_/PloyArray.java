package com.hspedu.ploy_.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        Person[] persons= new Person[5];
        persons[0] = new Person("smith", 19);
        persons[1] = new Student("smith", 18, 89.2);
        persons[2] = new Student("xiaoxue", 19, 32.2);
        persons[3] = new Teacher("milaoshi", 49, 5000);
        persons[4] = new Teacher("laoshi", 36, 4500);
        for (int i = 0; i < 5; i++) {
            System.out.println(persons[i].say());
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] instanceof Student) {
               Student student = (Student) persons[i];
                System.out.println(student.study());
            } else if(persons[i] instanceof Teacher) {
                Teacher teacher = (Teacher) persons[i];
                System.out.println(teacher.teach());
            } else {
                System.out.println("你的类型有误，请重新判断...");
            }
        }
    }
}
