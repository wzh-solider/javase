package com.hspedu.collection.list_.linkedlist_;

import java.util.Iterator;
import java.util.Scanner;

public class LinkedList_ {
    public static void main(String[] args) {
        Node node = new Node(null);
        node = add(node);
        iterator(node);
    }

    public static Node add(Object obj) {
        Node node = (Node)obj;
        Node head = node;
        Node newNode = new Node(null);
        System.out.println("请输入信息：");
        Integer item = new Scanner(System.in).nextInt();
        node.setItem(item);
        node.setPrev(null);
        while(item != 0) {
            System.out.print("请继续输入：");
            item = new Scanner(System.in).nextInt();
            newNode.setItem(item);
            node.setNext(newNode);
            newNode.setPrev(node);
            node = newNode;
            newNode = new Node(null);
        }
        head.setPrev(newNode);
        newNode.setNext(head);
        return head;
    }

    public static void iterator(Object obj) {
        Node node = (Node) obj;
        if (node.getPrev() == null)
            System.exit(0);
        while(node.getNext() != null) {
            System.out.println(node + " ");
            node = node.getNext();
        }
    }
}


