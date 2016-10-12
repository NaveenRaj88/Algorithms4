package com.chap3.sec3_1;


import alg.common.Node;

/**
 * Created by Naveen Kumar .A on 10/12/16.
 */
public class InorderTraversal {

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);

    }

    public static void main(String[] args) {
        Node<String, Integer> root = new Node<>("G", 1);
        root.left  = new Node<>("E", 2);
        root.right  = new Node<>("I", 3);
        root.left.left = new Node<>("D",6);
        root.left.right = new Node<>("F",6);
        inOrder(root);
    }

}
