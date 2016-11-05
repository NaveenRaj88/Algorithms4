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

    private Node get(Node root, String key, int d) {
        if (root == null) {
            return null;
        }
        if (d == key.length()) {
            return root;
        }
        char c = key.charAt(d);
        return get(root.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node root, String key, Value val, int d) {
        if (root == null) {
            root = new Node();
        }
        if (d == key.length()) {
            root.value = val;
            return root;
        }
        char c = key.charAt(d);
        root.next[c] = put(root.next[c], key, val, d + 1);
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
        for (Node node : root.next) {
            if (node != null) {
                count += size(node);
            }
        }
        return count;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) {
            return;
        }
        if (x.value != null) {
            queue.enqueue(pre);
        }
        for (char c = 0; c < r; c++) {
            collect(x.next[c], pre + c, queue);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> queue) {
        int d = pre.length();
        if (x == null) {
            return;
        }
        if (d == pat.length() && x.value != null) {
            queue.enqueue(pre);
        }
        if (d == pat.length()) {
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < r; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, queue);
            }
        }
    }

    public String longestPrefix(String pre) {
        int length = search(root, pre, 0, 0);
        return pre.substring(0, length);

    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.value != null) {
            length = d;
        }
        if (d == s.length()) {
            return length;
        }
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if(d == key.length()){
            x.value = null;
        }else{
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        if(x.value != null){
            return x;
        }
        for(char c =0; c<r; c++){
            if(x.next[c] != null){
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        TrieST<Integer> trieST = new TrieST();
        for (String s : a) {
            Integer in = trieST.get(s);
            if (in == null) {
                in = 0;
            }
            trieST.put(s, in);
        }
        System.out.println(trieST.longestPrefix("shell"));
    }
}
