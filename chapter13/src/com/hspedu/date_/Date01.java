package com.hspedu.date_;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class Date01 {
    public static void main(String[] args) throws ParseException{
        Date date1 = new Date();
        Date date2 = new Date(92020);
        System.out.println(date1.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(date1);
        System.out.println(format);
        String str = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(str);
        System.out.println(parse);
    }
}
