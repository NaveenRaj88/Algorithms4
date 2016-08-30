package com.chap05.sec5_2;

/**
 * Created by Naveen Kumar .A on 8/30/16.
 */
public class TrieST<Value> {

    private static int r = 256;
    private Node root;

    private static class Node {
        private Object value;
        private Node[] next = new Node[r];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.value;
    }

    private Node get(Node root, String key, int index) {
        if (root == null) {
            return null;
        }
        if (key.length() == index) {
            return null;
        }
        return get(root.next[key.charAt(index)], key, index++);
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node root, String key, Value val, int index) {
        if (root == null) {
            root = new Node();
        }
        if (index == key.length()) {
            root.value = val;
            return root;
        }
        root.next[key.charAt(index)] = put(root.next[key.charAt(index)], key, val, index + 1);
        return root;
    }

}
