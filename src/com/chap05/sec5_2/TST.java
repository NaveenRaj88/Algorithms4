package com.chap05.sec5_2;

/**
 * Created by Naveen Kumar .A on 11/5/16.
 */
public class TST<Value> {

    private Node root;

    private class Node {
        private char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if(d == key.length()){
            return x;
        }
        char c = key.charAt(d);
        if(x.c > c){
            return get(x.left, key, d+1);
        }else if(x.c < c){
            return get(x.right, key, d+1);
        }else{
            return get(x.mid, key, d+1);
        }
    }


}
