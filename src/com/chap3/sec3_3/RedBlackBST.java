package com.chap3.sec3_3;

/**
 * Created by Naveen Kumar .A on 8/12/16.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int n;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.n = n;
        }
    }

    private boolean isRed(Node h) {
        if (h == null) {
            return BLACK;
        }
        return h.color == RED;
    }



    public static void main(String[] args) {

    }
}
