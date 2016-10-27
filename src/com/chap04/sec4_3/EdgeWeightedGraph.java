package com.chap04.sec4_3;

import com.chap01.sec1_3.Bag;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 10/27/16.
 */
public class EdgeWeightedGraph {
    private int v;
    private int e;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v){
        this.v = v;
        this.e = 0;
        adj = new Bag[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public void addEdge(Edge edge){
        int v = edge.either();
        adj[v].add(edge);
        adj[edge.other(v)].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }


    public Iterable<Edge> edges(){
        Bag<Edge> edges = new Bag<>();
        for(Bag<Edge> bag : adj){
            for(Edge edg: bag){
                edges.add(edg);
            }
        }
        return edges;
    }

    public int v(){
        return v;
    }

}
