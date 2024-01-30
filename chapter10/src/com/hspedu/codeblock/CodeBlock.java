package com.hspedu.codeblock;

public class CodeBlock {
    public static void main(String[] args) {
        Movie movie = new Movie("长江七号");
        System.out.println("==========");
        Movie movie1 = new Movie("长江七号", 50.0);
        System.out.println("==========");
        Movie movie2 = new Movie("长江七号", 50.0, "周星驰");
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    {
        System.out.println("电影已经开始...");
        System.out.println("电影正在播放...");
        System.out.println("电影已经结束...");
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
