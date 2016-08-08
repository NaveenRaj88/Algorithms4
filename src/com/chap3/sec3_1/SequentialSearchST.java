package com.chap3.sec3_1;


import java.util.Iterator;

/**
 * Created by Naveen Kumar .A on 8/8/16.
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private int size = 0;

    private class Node {
        Key key;
        Value value;
        Node nextNode;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.nextNode = next;
        }
    }

    public Value get(Key key) {
        Node current = first;
        while (current != null) {
            if (key.equals(current.key)) {
                return current.value;
            }
            current = current.nextNode;
        }
        return null;
    }

    public void put(Key key, Value value) {
        Node current = first;
        while (current != null) {
            if (key.equals(current.key)) {
                current.value = value;
                return;
            }
            current = current.nextNode;
        }
        first = new Node(key, value, first);
        size++;
    }

    public void delete(Key key) {
        Node previousNode = null;
        Node current = first;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previousNode == null) {
                    first = current.nextNode;
                } else {
                    previousNode.nextNode = current.nextNode;
                }
                size--;
                return;
            }
            previousNode = current;
            current = current.nextNode;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private Node current = first;

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

}