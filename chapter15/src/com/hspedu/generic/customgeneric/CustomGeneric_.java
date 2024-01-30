package com.hspedu.generic.customgeneric;

public class CustomGeneric_ {
    public static void main(String[] args) {

    }
}

interface IUsb<U, R> {
    R get(U u);

    void hi(R r);
}

interface IA extends IUsb<String, Float> {
    void method();
}

class A implements IUsb<String , Integer> {
    @Override
    public Integer get(String s) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }
}

class B implements IA {
    @Override
    public Float get(String s) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void method() {

    }
}