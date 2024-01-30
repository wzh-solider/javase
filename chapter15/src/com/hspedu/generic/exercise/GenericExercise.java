package com.hspedu.generic.exercise;

import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<Student>();
        set.add(new Student("jack", 12));
        set.add(new Student("mark", 18));
        // Iterator 遍历
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Student stu = (Student) it.next();
            System.out.println(stu);
        }
        // 增强for 遍历
        for(Student stu : set) {
            System.out.println(stu);
        }

        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("mark", new Student("mark", 90));
        hashMap.put("hsp", new Student("hsp", 12));
        // 1. keySet, 按 key 匹配 value
        Set<String> keySet = hashMap.keySet();
        it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.println(key + "-" + hashMap.get(key));
        }
        for (String s : keySet) {
            System.out.println(s + "-" + hashMap.get(s));
        }
        // 2. 通过EntrySet，进行遍历
        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        for (Map.Entry o : entrySet) {
            System.out.println(o.getKey() + "-" + o.getValue());
        }
    }
}

class Student {
    private String name;

    private int age;
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}