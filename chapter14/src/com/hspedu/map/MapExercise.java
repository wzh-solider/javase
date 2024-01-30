package com.hspedu.map;

import java.util.*;

public class MapExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("NO1", new Employee("NO1", "jack", 12888));
        map.put("NO2", new Employee("NO2", "mark", 23666));
        map.put("NO3", new Employee("NO3", "hsp", 34888));
        // 使用 key 来匹配 value
        for (Object key : map.keySet()) {
            if (isBigger18000(map.get(key))) {
                System.out.println(map.get(key));
            }
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if (isBigger18000(map.get(key))) {
                System.out.println(map.get(key));
            }
        }

        // 直接通过 values()取出value
        Collection value = map.values();
        for (Object obj : value) {
            if (isBigger18000(obj)) {
                System.out.println(obj);
            }
        }
        Iterator it = value.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (isBigger18000(obj)) {
                System.out.println(obj);
            }
        }

        // 通过 EntrySet集合，取出 k-v
        Set entrySet = map.entrySet();
        Iterator iter = entrySet.iterator();
        while (iter.hasNext()) {
            Object obj =  iter.next();
            Map.Entry entry = (Map.Entry) obj;
            if(isBigger18000(entry.getValue())) {
                System.out.println(entry.getValue());
            }
        }
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            if (isBigger18000(entry.getValue())) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static boolean isBigger18000(Object obj) {
        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            if (employee.getSalary() > 18000)
                return true;
        }
        return false;
    }
}

class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
