package com.chap04.sec4_4;

import com.util.In;

/**
 * Created by Naveen Kumar .A on 10/27/16.
 */
public class EdgeWeightedDiGraph {

    private int[] adj;
    private int e;
    public EdgeWeightedDiGraph(int v){
        adj = new int[v];
    }

    public EdgeWeightedDiGraph(In in){
        this(in.readInt());
        e = in.readInt();

    }
}
