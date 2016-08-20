package com.chap04.sec4_2;

import com.chap01.sec1_3.Bag;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/17/16.
 */
public class DiGraph {

    private final int v;
    private int e;
    private Bag<Integer>[] adj;

    public DiGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public DiGraph(In in) {
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        e++;
    }

    public int v(){
        return v;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public DiGraph reverse() {
        DiGraph r = new DiGraph(v);
        for (int i = 0; i < v; i++) {
            for (int w : adj(i)) {
                r.addEdge(w, i);
            }
        }
        return r;
    }
}
