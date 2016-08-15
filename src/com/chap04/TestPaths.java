package com.chap04;

import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/14/16.
 */
public class TestPaths {
    public static void main(String[] args) {
        In in = new In("");
        int s =0;
        Graph g = new Graph(in);
        DepthFirstPaths search = new DepthFirstPaths(g,s);
        for (int v = 0; v <g.v() ; v++) {
            System.out.print(s + " to "+ v +": ");
            if(search.hasPathTo(v)){
                for (int x: search.pathTo(v)){
                    if(x == s){
                        System.out.print(x);
                    }else{
                        System.out.print("-"+x);
                    }
                }

            }
            System.out.println();
        }
    }
}
