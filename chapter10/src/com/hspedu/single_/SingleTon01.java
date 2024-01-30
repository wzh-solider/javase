package com.hspedu.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        System.out.println(girlFriend);
    }
}

class GirlFriend {
    private String name;

    private static GirlFriend girlFriend = new GirlFriend("小红");
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
