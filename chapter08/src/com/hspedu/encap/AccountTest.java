package com.hspedu.encap;

import com.hspedu.modifier.A;

import java.sql.PseudoColumnUsage;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("jack");
        account.setBalance(1299);
        account.setPassword("123456");
        System.out.println("Name = " + account.getName());
        System.out.println("Balance = " + account.getBalance());
        System.out.println("Password = " + account.getPassword());
    }
}
