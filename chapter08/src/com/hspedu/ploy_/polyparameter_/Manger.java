package com.hspedu.ploy_.polyparameter_;

public class Manger extends Employee{
    private int bouns;

    public Manger(String name, int salary, int bouns) {
        super(name, salary);
        this.bouns = bouns;
    }

    public int getBouns() {
        return bouns;
    }

    public void setBouns(int bouns) {
        this.bouns = bouns;
    }

    public String manage() {
        return "我是经理，我乐意";
    }

    @Override
    public int getANnual() {
        return super.getANnual() + getBouns();
    }
}
