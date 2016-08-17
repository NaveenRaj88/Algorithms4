package com.chap04.sec4_1;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph g) {
        marked = new boolean[g.v()];
        id = new int[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int i) {
        marked[i] = true;
        id[i] = count;
        for (int w : g.adj(i)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v , int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

}
