package com.chap04;

import com.chap01.sec1_3.Queue;
import com.chap01.sec1_3.Stack;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class BreadthFirstPaths {

    private boolean[] marked;

    private int[] edgeTo;

    private int s;

    public BreadthFirstPaths(Graph g, int s){
        marked= new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        bfs(g,s);
    }

    private void bfs(Graph g, int s){
        Queue<Integer> path = new Queue<>();
        marked[s] = true;
        path.enqueue(s);
        while(!path.isEmpty()){
            int v = path.dequeue();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    edgeTo[w] =v;
                    marked[w] =true;
                    path.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!marked[v]){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int w = v; w!= s; w = edgeTo[w]){
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
