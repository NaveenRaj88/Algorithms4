package com.chap05.sec5_2;

/**
 * Created by Naveen Kumar .A on 11/21/16.
 */

import java.util.*;

public class TriesWithHashMap {

    private  Node root;

    private class Node {
        String data;
        HashMap<Character, Node> mapNode;
        public Node(){
            mapNode = new HashMap<>();
        }
        public Node(String data, HashMap<Character, Node> mapNode){
            this.data = data;
            this.mapNode = mapNode;
        }
    }

    private  void add(String contact){
        root = add(root, contact, 0);
    }
    private  Node add(Node root, String contact, int index){
        if(root == null){
            root = new Node();
        }

        if(index == contact.length()){
            root.data = contact;
            return root;
        }
        Character c = contact.charAt(index);
        if(!root.mapNode.containsKey(c)){
            root.mapNode.put(c, new Node());
        }
        HashMap<Character, Node> map = root.mapNode;
        Node node = map.get(c);
        node = add(map.get(c), contact, index+1);
        return node;
    }

    private  Node get(Node root, String key, int d){
        if(root == null){
            return null;
        }
        if(d == key.length()){
            return root;
        }
        return get(root.mapNode.get(key.charAt(d)), key, d+1);
    }

    private  Queue<String> find(String key){
        Queue<String> queue = new LinkedList<>();
        findPrefixStrings(get(root,key, 0 ),key, queue);
        return queue;
    }

    private static void findPrefixStrings(Node root,String pre, Queue<String> queue){
        if(root == null){
            return;
        }
        if(root.data != null){
            queue.add(root.data);
        }
        for(Character charac: root.mapNode.keySet()){
            findPrefixStrings(root.mapNode.get(charac), pre+charac, queue);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TriesWithHashMap tr = new TriesWithHashMap();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
                tr.add(contact);
            }else if(op.equals("find")){
                Queue<String> queue = tr.find(contact);
                System.out.println(queue.size());
            }

        }
    }
}