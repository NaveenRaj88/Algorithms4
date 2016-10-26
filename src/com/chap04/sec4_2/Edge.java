package com.chap04.sec4_2;

/**
 * Created by Naveen Kumar .A on 10/26/16.
 */
public class Edge implements Comparable<Edge>{

    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w , double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int v){
        if(this.v == v){
            return w;
        }
        return v;
    }

    @Override
    public int compareTo(Edge that) {

    }
}
