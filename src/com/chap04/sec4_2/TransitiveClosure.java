package com.chap04.sec4_2;

/**
 * Created by Naveen Kumar .A on 10/25/16.
 */
public class TransitiveClosure {

    private DirectedDFS[] directedDFSes;

    public TransitiveClosure(DiGraph g){
        directedDFSes = new DirectedDFS[g.v()];
        for (int i = 0; i <g.v(); i++) {
            directedDFSes[i] = new DirectedDFS(g,i);
        }
    }

    public boolean reachable(int v, int w){
        return directedDFSes[v].marked(w);
    }
}
