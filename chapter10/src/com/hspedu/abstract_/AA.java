package com.hspedu.abstract_;

abstract class AA {
    // 1 + ... + 10000
    public abstract void sum();
    public long caleTimes() {
        long start = System.currentTimeMillis();
        sum();
        long end = System.currentTimeMillis();
        return end - start;
    }
}

class BB extends AA {
    private int a = 1;
    public void sum() {
        long sum = 0;
        for (long i = 1; i <= 100000; i++) {
            sum += i;
        }
    }
}