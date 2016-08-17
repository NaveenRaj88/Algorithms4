package com.chap04.sec4_1;

import com.chap01.sec1_3.Bag;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class ConnectedComponentsClient {
    public static void main(String[] args) {


        In in = new In("resources/tinyG.txt");
        Graph g = new Graph(in);
        ConnectedComponents cc = new ConnectedComponents(g);
        int m = cc.count();
        System.out.println(m +" components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[m];

        for (int i = 0; i <m ; i++) {
            if(components[i] ==null){
                components[i] = new Bag<>();
            }
            components[cc.id(i)].add(i);
        }
        for(int i =0; i<m;i++){
            for(int j : components[i]){
                System.out.println(j+" ");
            }
            System.out.println();
        }

    }
}
