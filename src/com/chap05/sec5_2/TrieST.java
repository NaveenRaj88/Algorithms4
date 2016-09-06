package com.chap05.sec5_2;

import com.chap01.sec1_3.Queue;

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
            return root;
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

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.value != null) {
            count++;
        }
        for (char c = 0; c < r; c++) {
            count += size(root.next[c]);
        }
        return count;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> queue = new Queue<>();
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    private void collect(Node root, String pre, Queue<String> keys) {
        if (root == null) {
            return;
        }
        if (root.value != null) {
            keys.enqueue(pre);
        }
        for (char c = 0; c < r; c++) {
            collect(root.next[c], pre + c, keys);
        }
    }


}