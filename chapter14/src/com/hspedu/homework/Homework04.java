package com.hspedu.homework;

/**
 *  简答出，HashSet 和 TreeSet 的去重机制
 */
public class Homework04 {
    public static void main(String[] args) {
        // 1. HashSet
        /*  hashCode() + equals()。底层先进行运算，计算出传入对象的hash值，然后通过这个hash值
            通过hash值计算出对应的索引，如果该索引位置没有数据，则直接加入；否则通过equals进行比较
            【如果该索引为链表，则进行循环比较】，不相同加入到该索引数据之后，相同则不加入。
         */

        // 2. TreeSet
        /*
            - 如果传入了一个comparator匿名对象，就通过这个对象的规则进行加入；返回0，不加入。
            - 如果没有传入，那么以添加对象 实现 的compareable接口的 compareTo去重
         */
    }
}
