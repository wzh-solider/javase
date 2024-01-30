package com.hspedu.homework;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Solider
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        ReadKey readKey = new ReadKey(printNumber);
        printNumber.start();
        readKey.start();
    }
}

class PrintNumber extends Thread {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            Random random = new Random();
            int i = random.nextInt(100);
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ReadKey extends Thread {
    PrintNumber printNumber;
    Scanner scanner = new Scanner(System.in);
    public ReadKey(PrintNumber printNumber) {
        this.printNumber = printNumber;
    }
    @Override
    public void run() {
        while(true) {
            System.out.println("请输入指令");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                printNumber.setLoop(false);
                break;
            }
        }
    }
}