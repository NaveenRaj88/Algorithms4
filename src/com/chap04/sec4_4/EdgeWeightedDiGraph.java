package com.chap04.sec4_4;

import com.chap01.sec1_3.Bag;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 10/27/16.
 */
public class EdgeWeightedDiGraph {

    private Bag<DirectedEdge>[] adj;
    private int v;
    private int e;

    public EdgeWeightedDiGraph(int v){
        this.v = v;
        this.e =0;
        adj = new Bag[v];
    }

    public EdgeWeightedDiGraph(In in){
        this(in.readInt());
        int edges = in.readInt();
        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v,w,weight));
            e++;
        }
    }

    public void addEdge(DirectedEdge edge){
            adj[edge.from()].add(edge);
        e++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> edges = new Bag<>();
        for(Bag<DirectedEdge> bags : adj){
            for (DirectedEdge dEdge : bags){
                edges.add(dEdge);
            }
        }
        return edges;
    }

    public int v(){
        return v;
    }

    public int e(){
        return e;
    }


}
