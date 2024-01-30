package com.hspedu.collections_tools;

import java.util.*;

public class Collections_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(20);
        list.add(10);
        list.add(3);
        list.add(5);
        list.add(9);
        // 反转集合中的元素
        Collections.reverse(list);
        // 集合中的元素进行随机排序
        Collections.shuffle(list);
        // 将集合中的元素按照升序排列
        Collections.sort(list);
        // 自己指定排列的规则
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });
        // 将集合中的元素进行交换
        Collections.swap(list, 0, 4);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.print(next + " ");
        }
        System.out.println();

        // 返回集合中的最大元素，返回Object类型
        Integer i = (Integer) Collections.max(list);
        int max = i.intValue();
        System.out.println("集合中的最大元素 = " + max);
        Object o = Collections.max(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });
        System.out.println("Comparator规则找出集合中的最大值 = " + o);

        // 统计集合中某个对象出现的次数，返回int类型
        int n = Collections.frequency(list, 5);
        System.out.println("集合中5出现的次数 = " + n);

        // List集合的拷贝
        List dest = new ArrayList();
        // 因为在进行集合拷贝的时候，底层源码会进行比较
        // dest的集合长度 < src的集合长度时 ==> 抛出数组下标越界异常
        for (i = 0; i < 5; i++) {
            dest.add("");
        }
        Collections.copy(dest, list);
        System.out.println("dest = " + dest);

        // 使用新值替换旧值
        Collections.replaceAll(list, 5, 100);
        System.out.println("replaceAll = " + list);
    }
}
