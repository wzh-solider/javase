package com.hspedu.exception;

import javax.management.RuntimeErrorException;

public class CustomException {
    public static void main(String[] args) {
        int age = 1;
        if (age < 18 || age > 120) {
            throw new OutOfAgeException("年龄需要在18 ~ 120之间");
        }
        System.out.println("年龄正确");
    }
}
class OutOfAgeException extends RuntimeException {
    public OutOfAgeException(String message) {
        super(message);
    }
}