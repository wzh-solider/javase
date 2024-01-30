package com.hspedu.encap;

public class Account {
    private String name;
    private int balance;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("your name length must two bit, three or four bit!");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("your balance isn't enough!");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("your password must six bit!");
            this.password = "666666";
        }
    }
}
