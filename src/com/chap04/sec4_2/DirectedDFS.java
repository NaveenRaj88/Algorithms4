package com.chap04.sec4_2;

import com.chap01.sec1_3.Bag;
import com.chap04.sec4_1.Graph;
import com.util.In;

import java.util.Iterator;

/**
 * Created by Naveen Kumar .A on 8/19/16.
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(DiGraph g, int s){
        marked = new boolean[g.v()];
        dfs(g,s);
    }

    public DirectedDFS(DiGraph g, Iterable<Integer> sources){
        marked = new boolean[g.v()];
        for(int s: sources){
            if(!marked[s]){
                dfs(g,s);
            }
        }
    }

    public void dfs(DiGraph g, int v){
        marked[v] = true;
        for (int w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }


    public static void main(String[] args) {
        DiGraph g = new DiGraph(new In("resources/tinyDG.txt"));
        Bag<Integer> sources = new Bag<>();
        sources.add(2);
        DirectedDFS reachable = new DirectedDFS(g,sources);
        for (int v=0; v<g.v(); v++){
            if(reachable.marked(v)){
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
}
