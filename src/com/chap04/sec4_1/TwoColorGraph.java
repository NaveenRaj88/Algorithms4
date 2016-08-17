package com.chap04.sec4_1;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class TwoColorGraph {

    private boolean[] marked;

    private boolean[] color;

    private boolean isTwoColorable = true;

    public TwoColorGraph(Graph g) {
        marked = new boolean[g.v()];
        color = new boolean[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(Graph g, int i) {
        marked[i] = true;
        for (int w : g.adj(i)) {
            if (!marked[w]) {
                color[w] = !color[i];
                dfs(g, w);
            } else if (color[w] == color[i]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

}
