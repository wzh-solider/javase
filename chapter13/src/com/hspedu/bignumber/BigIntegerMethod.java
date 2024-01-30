package com.hspedu.bignumber;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerMethod {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("111111111111111111111");
        BigInteger a = new BigInteger("100");
        // +
        BigInteger add = b.add(a);
        System.out.println(add);
        // -
        BigInteger subtract = b.subtract(a);
        System.out.println(subtract);
        // *
        BigInteger multiply = b.multiply(a);
        System.out.println(multiply);
        // /
        BigInteger divide = b.divide(a);
        System.out.println(divide);

        BigDecimal bd = new BigDecimal("23.2288282828828828939939");
        BigDecimal b2 = new BigDecimal("3");
        System.out.println(bd.divide(b2, BigDecimal.ROUND_CEILING));
    }
}
