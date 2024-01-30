package com.hspedu.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDate_ {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println(ld + " " + lt);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("年份：" + ldt.getYear());
        System.out.println("月份：" + ldt.getMonth());
        System.out.println("月份：" + ldt.getMonthValue());
        System.out.println("日：" + ldt.getDayOfMonth());
        System.out.println("时：" + ldt.getHour());
        System.out.println("分：" + ldt.getMinute());
        System.out.println("秒：" + ldt.getSecond());
    }
}
