package com.hspedu.string_;

public class StringExercise {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};
    public void change(String str, char[] ch) {
        str = "java";
        ch[0] = 'h';
    }
    public static void main(String[] args) {
        StringExercise st = new StringExercise();
        st.change(st.str, st.ch);
        System.out.println(st.str + "and");
        System.out.println(st.ch);
    }
}
