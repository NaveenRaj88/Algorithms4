package com.chap3.sec3_1;


import alg.common.Node;

/**
 * Created by Naveen Kumar .A on 10/12/16.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public int size(Node root){
        if(root == null){
            return 0;
        }
        return root.n;
    }

    public int calcSize(Node root){
        if(root == null){
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }

    public Value get(Key key){
        root.key.compareTo(key);
        key.compareTo(root.key);
       return get(root, key);
    }

    private Value get(Node<Key,Value> x, Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            get(x.left, key);
        }else if(cmp > 0){
            get(x.right, key);
        }else{
            return x.value;
        }
        return null;
    }

    public void put(Key key, Value value){

    }

    private Node put(Node<Key, Value> root, Key key, Value value){
        if(key == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if(cmp < 0 ){
            root.left = put(root.left, key, value);
        }else if(cmp > 0){
            root.right = put(root.right, key, value);
        }else{
            root.value = value;
        }
        root.n = size(root.left)+ size(root.right)+1;
        return root;
    }
}
