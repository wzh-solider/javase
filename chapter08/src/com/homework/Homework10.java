package com.homework;

public class Homework10 {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("jack", 18, "Doctor", 2, 2000);
        Doctor d2 = new Doctor("jac", 18, "Doctor", 2, 2000);
        System.out.println(d1.equals(d2));
    }
}

class Doctor {
    String name;
    int age;
    String job;
    int gender;
    double sal;

    public Doctor(String name, int age, String job, int gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        Doctor d = (Doctor)obj;
        if (this.name.equals(d.name) &&
            this.age == d.age &&
            this.job.equals(d.job) &&
            this.gender == d.gender &&
            this.sal == d.sal) return true;
        return false;
    }
}
