package com.chap04.sec4_1;

import com.chap01.sec1_3.Bag;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/13/16.
 */
public class Graph {

    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    Graph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
