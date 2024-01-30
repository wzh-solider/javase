package com.hspedu.ploy_.polyparameter_;

import com.hspedu.ploy_.polyarr_.PloyArray;

import javax.crypto.spec.PSource;

public class PolyParameter {
    public static void main(String[] args) {
        OrdinaryEmpolyee e1 = new OrdinaryEmpolyee("工人", 2000);
        Manger e2 = new Manger("经理", 5000, 2000);
        PolyParameter polyParameter = new PolyParameter();
        System.out.println(polyParameter.showEmpAnnal(e1));
        System.out.println(polyParameter.showEmpAnnal(e2));
        System.out.println(polyParameter.testWork(e1));
        System.out.println(polyParameter.testWork(e2));
    }
    public int showEmpAnnal(Employee e) {
        return e.getANnual();
    }
    public String testWork(Employee e) {
        if (e instanceof OrdinaryEmpolyee) {
            return ((OrdinaryEmpolyee)e).work();
        } else {
            return ((Manger)e).manage();
        }
    }
}
