package com.chap3.sec3_1;


public class SequentialSearchST<Key, Value> {

    public Node first;
    public int size;

    public class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node f = first; f != null; f = f.next) {
            if (first.key.equals(key)) {
                return f.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node f = first; f != null; f = f.next) {
            if (f.key.equals(key)) {
                f.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        size++;
    }

    public int size() {
        return size;
    }

    public void delete(Key key) {
        Node node = first;
        if (node.key.equals(key)) {
            first = first.next;
            size--;
            return;
        }
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                break;
            }
            node = node.next;
        }
    }
}