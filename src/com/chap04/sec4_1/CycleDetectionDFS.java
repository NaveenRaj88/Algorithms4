package com.chap04.sec4_1;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class CycleDetectionDFS {
    private boolean[] marked;
    private boolean hasCycle;

    public CycleDetectionDFS(Graph g){
        marked = new boolean[g.v()];
        for(int s =0; s< g.v(); s++){
            if(!marked[s]){
                dfs(g, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int u){
        marked[v] = true;
        for (int w : g.adj(v)){
            if(!marked[w]){
                dfs(g, w, v);
            }else if(w != u){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

}
