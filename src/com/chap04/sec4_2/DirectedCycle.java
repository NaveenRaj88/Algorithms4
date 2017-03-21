package com.chap04.sec4_2;

import com.chap01.sec1_3.Stack;

/**
 * Created by Naveen Kumar .A on 8/20/16.
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(DiGraph g) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        onStack = new boolean[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i]) {

            }
        }
    }

    private void dfs(DiGraph g, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : g.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}


