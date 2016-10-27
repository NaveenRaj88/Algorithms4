package com.chap04.sec4_3;

import com.chap01.sec1_3.Queue;
import com.chap01.sec1_5.QuickUnion;
import com.chap2.sec_2_4.MinPQ;

/**
 * Created by Naveen Kumar .A on 10/27/16.
 */
public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph ewg) {
        MinPQ<Edge> pq = new MinPQ();
        for (Edge edge : ewg.edges()) {
            pq.insert(edge);
        }
        QuickUnion qu = new QuickUnion(ewg.v());

        while (!pq.isEmpty() && mst.size() < ewg.v() - 1) {
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (qu.connected(v, w)) {
                continue;
            }
            qu.union(v, w);
            mst.enqueue(minEdge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double totWeight = 0.0;
        for (Edge edge : edges()) {
            totWeight+=edge.weight();
        }
        return totWeight;
    }
}
