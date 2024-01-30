package com.hspedu.date_;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat_ {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒E");
        LocalDateTime ldt = LocalDateTime.now();
        String str = dtf.format(ldt);
        System.out.println(str);
        Instant instant = Instant.now();
        System.out.println(instant);

        // LocalDateTime 提供时间加减
        LocalDateTime localDateTime = ldt.plusDays(100);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = ldt.minusHours(3456);
        System.out.println(dtf.format(localDateTime1));
    }
}
