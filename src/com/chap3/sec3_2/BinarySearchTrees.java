package com.chap3.sec3_2;

/**
 * Created by Naveen Kumar .A on 8/11/16.
 */
public class BinarySearchTrees<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

    }

    public int size() {
        return size(root);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = root.key.compareTo(key);

        if (cmp < 0) {
            get(root.right, key);
        } else if (cmp > 0) {
            get(root.left, key);
        }
        return root.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {

        if (root == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
        }
        root.n = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public Key max() {
        return null;
    }

    private Key max(Node root) {
        if (root.right == null) {
            return root.key;
        }
        return max(root.right);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            return root;
        } else if (cmp < 0) {
            return floor(root.right, key);
        }
        Node t= floor(root.left, key);
        if(t!= null){
            return t;
        }else{
            return root;
        }

    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node root, int k){
        if(root == null){
            return null;
        }
        int t = size(root.left);
        if(t> k){
            return select(root.left, k);
        }else if(t < k){
            return select(root.right, k-t-1);
        }
        return root;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node root, Key key){
        if(root == null){
            return 0;
        }
        int cmp = root.key.compareTo(key);
        if(cmp <0){
            return 1+ size(root.left)+rank(root.right, key);
        }else if(cmp > 0 ){
            return rank(root.left, key);
        }
        return size(root.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node root){
        if(root.left == null){
            return root.right;
        }
        root.left = deleteMin(root.left);
        root.n = size(root.left)+size(root.right)+1;
        return root;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node root, Key key){
        if(root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if(cmp <0){
            root.left =  delete(root.left, key);
        }else if(cmp >0){
            root.right =  delete(root.right, key);
        }else{
            if(root.right == null){
                return root.left;
            }
            if(root.left == null){
                return root.right;
            }
            Node t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        root.n = size(root.left) + size(root.right)+1;
        return root;
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return -1;
        }
        return 1+ Math.max(height(root.left), height(root.right));
    }

    public Iterable<Key> keys() {
        return null;
    }

    public static void main(String[] args) {

    }
}
