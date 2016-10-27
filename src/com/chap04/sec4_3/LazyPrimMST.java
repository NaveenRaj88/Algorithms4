package com.chap04.sec4_3;

import com.chap01.sec1_3.Queue;
import com.chap2.sec_2_4.MinPQ;

/**
 * Created by Naveen Kumar .A on 10/27/16.
 */
public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> minPQ;

    public LazyPrimMST(EdgeWeightedGraph ewd) {
        minPQ = new MinPQ<>();
        marked = new boolean[ewd.v()];
        mst = new Queue<>();

        visit(ewd, 0);
        while (!minPQ.isEmpty()) {
            Edge minEdge = minPQ.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(minEdge);
            if (!marked[v]) {
                visit(ewd, v);
            }
            if (!marked[w]) {
                visit(ewd, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge edge : g.adj(v)) {
            if (!marked[edge.other(v)]) {
                minPQ.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double totalWeight = 0.0;
        for (Edge edge : edges()) {
            totalWeight += edge.weight();
        }
        return totalWeight;
    }
}
