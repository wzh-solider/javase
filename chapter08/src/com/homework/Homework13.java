package com.homework;

public class Homework13 {
    public static void main(String[] args) {
        Person_[] person = new Person_[4];
        person[0] = new Students("jack", '男', 18, 10001);
        person[1] = new Students("mark", '女', 19, 10002);
        person[2] = new Teacher_("jason", '女', 38, 20);
        person[3] = new Teacher_("jason", '女', 40, 30);
        Homework13 h = new Homework13();
        for (int i = 0; i < 4; i++) {
            h.show(person[i]);
        }
        Homework13.sort(person);
        for (Person_ i : person) {
            System.out.println(i.toString());
        }
        System.out.println(person[0].getClass());
    }

    public static void sort(Person_[] person) {
        Person_ temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
    }

    public static void show(Person_ person) {
        if (person instanceof Students) {
            Students stu = (Students) person;
            System.out.println(stu.toString());
            stu.study();
            System.out.println(stu.play());
            System.out.println("-------------------");
        } else if (person instanceof Teacher_){
            Teacher_ tea = (Teacher_) person;
            System.out.println(tea.toString());
            tea.teach();
            System.out.println(tea.play());
            System.out.println("-------------------");
        } else {
            System.out.println("没有此对象");
        }
    }
}

class Person_ {
    private String name;
    private char sex;
    private int age;

    public Person_(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return name;
    }

}

class Students extends Person_ {
    private long stu_id;

    public Students(String name, char sex, int age, long stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public long getStu_id() {
        return stu_id;
    }

    public void setStu_id(long stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    public String play() {
        return super.play() + "爱玩足球";
    }

    @Override
    public String toString() {
        return "学生的信息\n" +
                "姓名：" + super.getName() + '\n' +
                "年龄：" + super.getAge() + '\n' +
                "性别：" + super.getSex() + '\n' +
                "学号：" + this.getStu_id();
    }
}

class Teacher_ extends Person_ {
    private int work_age;

    public Teacher_(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学。");
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    public String toString() {
        return "老师的信息\n" +
                "姓名：" + super.getName() + '\n' +
                "年龄：" + super.getAge() + '\n' +
                "性别：" + super.getSex() + '\n' +
                "工龄：" + this.getWork_age();
    }
}
