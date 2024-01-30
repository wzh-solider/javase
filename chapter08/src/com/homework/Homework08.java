package com.homework;

public class Homework08 {
    public static void main(String[] args) {
        BankAccount b = new CheckingAccount(1000);
        b.deposit(200);
        b.show();
        b.withdraw(100);
        b.show();
        BankAccount ba = new SavingAccount(1000);
        for (int i = 1; i <= 3; i++) {
            ba.deposit(200);
        }
        ba.show();
        ba.deposit(200);
        ba.show();
    }
}

class BankAccount {
    private double balance;
    int monthInterest;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void earnMonthInterest() {
        monthInterest = 0;
    }

    public void show() {
        System.out.println("资金：" + balance);
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount - 1);
    }
}

class SavingAccount extends CheckingAccount {
    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.monthInterest++;
        if (super.monthInterest <= 3) {
            super.deposit(amount + 1);
        } else {
            super.deposit(amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        super.monthInterest++;
        if (super.monthInterest <= 3) {
            super.deposit(amount + 1);
        } else {
            super.deposit(amount);
        }
    }

    @Override
    public void show() {
        super.show();
    }
}
