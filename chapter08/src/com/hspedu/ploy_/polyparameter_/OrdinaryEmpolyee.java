package com.hspedu.ploy_.polyparameter_;

public class OrdinaryEmpolyee extends Employee{
    public OrdinaryEmpolyee(String name, int salary) {
        super(name, salary);
    }
    public String work() {
        return "工作工作工作";
    }
    @Override
    public int getANnual() {
        return super.getANnual();
    }
}
