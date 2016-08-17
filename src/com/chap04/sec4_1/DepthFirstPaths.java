package com.chap04.sec4_1;

import com.chap01.sec1_3.Stack;

/**
 * Created by Naveen Kumar .A on 8/14/16.
 */
public class DepthFirstPaths {

    private boolean[] marked;

    private int[] edgeTo;

    private int s;

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int i : g.adj(s)) {
            if (!marked[i]) {
                edgeTo[i] = s;
                dfs(g, s);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }
}
