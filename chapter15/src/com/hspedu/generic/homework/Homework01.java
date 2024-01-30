package com.hspedu.generic.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO();

        userDAO.save("01", new User(01, 12, "jack"));
        userDAO.save("02", new User(02, 14, "mary"));
        userDAO.save("03", new User(03, 18, "hsp"));
        System.out.println(userDAO.get("01"));
        userDAO.update("02", new User(10, 29, "entry"));
        System.out.println(userDAO.list());
        userDAO.delete("02");
        System.out.println(userDAO.list());
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public T get(String id) {
        return map.get(id);
    }
    public void update(String id, T entity) {
        map.put(id, entity);
    }
    public List<T> list() {
        return new ArrayList<>(map.values());
    }
    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id, age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}