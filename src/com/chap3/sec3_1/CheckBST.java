package com.chap3.sec3_1;

import alg.common.Node;

/**
 * Created by Naveen Kumar .A on 10/12/16.
 */
public class CheckBST<Key extends Comparable<Key>, Value> {

    public static boolean isBST(Node root){
        if(root == null){
            return true;
        }
        Node left = root.left;
        Node right = root.right;
        if(left != null && root.key.compareTo(left.key) <0 ){
            return false;
        }
        if(right != null && root.key.compareTo(right.key) >0){
            return false;
        }
        return isBST(left) && isBST(right);
    }

    public static void main(String[] args) {
        Node<String, Integer> root = new Node<>("G", 1);
        root.left  = new Node<>("E", 2);
        root.right  = new Node<>("I", 3);
        root.left.left = new Node<>("D",6);
        root.left.right = new Node<>("F",6);
        System.out.println(isBST(root));
    }
}
