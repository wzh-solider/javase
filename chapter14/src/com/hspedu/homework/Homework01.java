package com.hspedu.homework;

import java.util.*;

public class Homework01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月钱钓的鱼还在网兜里，捞起一看赶紧放生");
        List list = new ArrayList();
        list.add(news1);
        list.add(news2);
        Collections.reverse(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            next = ifLengthBigger15(next);
            System.out.println(next);
        }
    }

    public static Object ifLengthBigger15(Object obj) {
        String str = ((News) obj).getTitle();
        if (str.length() > 15) {
            str = str.substring(0, 15) + "...";
        }
        return str;
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "新闻的标题为：" + this.title;
    }
}