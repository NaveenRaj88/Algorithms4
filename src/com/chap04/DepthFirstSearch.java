package com.chap04;

/**
 * Created by Naveen Kumar .A on 8/13/16.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.v()];
        dfs(g,s);
    }

    private void dfs(Graph g, int v){
        marked[v] = true;
        count++;
        for (int i: g.adj(v)){
            if(!marked(i)){
                dfs(g,i);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
