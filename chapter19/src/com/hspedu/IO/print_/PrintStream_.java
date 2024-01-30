package com.hspedu.IO.print_;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author Solider
 * @version 1.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        // System.out在底层，编译类型为 PrintStream
        PrintStream out = System.out;
        // 默认情况下，PrintStream 输出位置为 标准输出，即显示器
        out.print("join, hello");
//        public void print(String s) {
//            write(String.valueOf(s));
//        }
        // print()方法在底层同样执行了write()方法
        // 所以可以直接使用write()方法进行打印
        out.write("韩顺平".getBytes());
        out.close();
        // 因为打印流的本质还是一个流，所以我们也可以自定义打印位置
        PrintStream ps = new PrintStream("D:\\c.txt");
        System.setOut(ps); // 将打印位置改为 D:\\c.txt
        System.out.print("打印位置改变");
        ps.close();
    }
}
