package com.hspedu.homework;

import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String[] str = name.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(str[2]).append(", ").append(str[0]).append(" .").append(str[1].charAt(0));
        System.out.println(sb);
    }
}
