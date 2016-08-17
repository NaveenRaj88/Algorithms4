package com.chap04.sec4_1;

import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/14/16.
 */
public class TestSearch {

    public static void main(String[] args) {
        In in = new In("");
        Graph g = new Graph(in);
        int s = 0;

        DepthFirstSearch search = new DepthFirstSearch(g, s);

        for (int i = 0; i < g.v(); i++) {
            if(search.marked(i)){
                System.out.print(i +" ");
            }
            System.out.println();
        }

        if (search.count() != g.v()){
            System.out.print("Not ");
        }
        System.out.println("Connected");
    }
}
