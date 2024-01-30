package com.hspedu.homework;

public class Homework07 {
    public static void main(String[] args) {
        new Car(100).getAir().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature >= 40) {
                System.out.println("吹冷风");
            } else if (temperature <= 0) {
                System.out.println("吹暖风");
            } else {
                System.out.println("关闭空调");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}
