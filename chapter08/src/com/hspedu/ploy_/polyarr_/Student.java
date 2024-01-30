package com.hspedu.ploy_.polyarr_;

class Student extends Person{
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\t" + this.score;
    }
    public String study() {
        return "我爱学习";
    }
}

class Teacher extends Person {
    private int salary;

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + "\t" + this.salary;
    }
    public String teach() {
        return "我爱教书";
    }

}
