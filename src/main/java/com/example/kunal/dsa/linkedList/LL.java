package com.example.kunal.dsa.linkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if(tail == null) tail = head;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (tail == null) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addIndex(int data, int index){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for(int i=0; i<index-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void removeFirst(){
        if(head == null) throw new IllegalStateException("List is empty");
        head = head.next;
        if(head == null) tail = null;
        size--;
    }

    public void removeLast(){
        if(head == null) throw new IllegalStateException("List is empty");
        if(head.next == null){
            head = tail = null;
        } else {
            Node current = head;
            while(current.next != tail){
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void removeIndex(int index){
        if(index < 0  || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        if (index == 0){
            removeFirst();
            return;
        }
        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if(temp.next == null) tail = temp;
        size--;
    }

    public void display() {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
