package com.单项链表;

public class LinkNodess {
    Node head=null;
    class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    /**
     * 一个数据插入链表
     * @param d
     */
    public void addNode(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

//    public boolean deleteNode(int index){
//        i
//    }
}





