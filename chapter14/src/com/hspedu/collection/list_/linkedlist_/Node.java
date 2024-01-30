package com.hspedu.collection.list_.linkedlist_;

public class Node {
    private Object item;
    private com.hspedu.collection.list_.linkedlist_.Node prev;
    private com.hspedu.collection.list_.linkedlist_.Node next;

    public Node(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}
