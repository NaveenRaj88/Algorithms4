package com.chap3.sec3_1;

import java.util.Iterator;

/**
 * Created by Naveen Kumar .A on 8/10/16.
 */
public class OrderedSequentialSearchST_EX_3_1_3<Key extends Comparable<Key>, Value> {

    private Node first;

    private int size;

    private class Node {
        Key key;
        Value value;
        Node nextNode;

        Node(Key key, Value value, Node nextNode) {
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    public Value get(Key key) {
        Node current = first;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.nextNode;
        }
        return null;
    }

    public void put(Key key, Value value) {
        Node rankNode = rank(key);
        if (rankNode == null) {
            first = new Node(key, value, first);
        } else if (rankNode.key.equals(key)) {
            rankNode.value = value;
        } else {
            rankNode.nextNode = new Node(key, value, rankNode.nextNode);
        }
    }

    private Node rank(Key key) {
        Node prev = null;
        Node current = first;
        while (current != null) {
            if (current.key.compareTo(key) >0) {
                return prev;
            }
            prev = current;
            current = current.nextNode;
        }
        return prev;
    }

    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    Node current = first;

                    @Override
                    public boolean hasNext() {
                        return current != null;
                    }

                    @Override
                    public Key next() {
                        Key key = current.key;
                        current = current.nextNode;
                        return key;
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST_EX_3_1_3<String, Integer> or = new OrderedSequentialSearchST_EX_3_1_3();
        String[] s = "SEARCHEXAMPLE".split("");
        for (int i = 0; i < s.length; i++) {
            or.put(s[i], i);
        }

        for (String str : or.keys()) {
            System.out.println(str + " " + or.get(str));
        }
    }
}
