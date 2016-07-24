package com.chap01.sec1_3;

import com.chap01.Node;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    // create an empty bag
    public Bag() {

    }

    // add an item
    public void add(Item item) {
        Node<Item> node = new Node<>(item);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item> {
        Node<Item> firstNode = head;

        @Override
        public boolean hasNext() {
            return head.nextNode != null;
        }

        @Override
        public Item next() {
            Item item = firstNode.item;
            firstNode = firstNode.nextNode;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Stack<String>[] a =  (Stack<String>[])new Stack[10];
    }
}
