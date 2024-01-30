package com.hspedu.extend_.exercise;

public class ExtendsExercise03 {
    public static void main(String[] args) {
        PC pc = new PC("78", "128", "jian", "ping");
        NotePad notePad = new NotePad("68", "168", "jian", "write");
        System.out.println(pc.getDetils() + "\n" + notePad.getDetails());
    }
}

class Computer {
    String CPU;
    String memory;
    String hardDisk;

    public Computer(String CPU, String memory, String hardDisk) {
        this.CPU = CPU;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }

    public String getDetails() {
        return "CPU:"+ CPU+ " 内存:" + memory + " 硬盘:" + hardDisk;
    }
}

class PC extends Computer {
    String brand;

    public PC(String CPU, String memory, String hardDisk, String brand) {
        super(CPU, memory, hardDisk);
        this.brand = brand;
    }
    public String getDetils() {
        return super.getDetails() + brand;
    }
}

class NotePad extends Computer {
    String color;

    public NotePad(String CPU, String memory, String hardDisk, String color) {
        super(CPU, memory, hardDisk);
        this.color = color;
    }

    public String getDetails() {
        return super.getDetails() + color;
    }
}
