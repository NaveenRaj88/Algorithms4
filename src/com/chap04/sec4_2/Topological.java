package com.chap04.sec4_2;

import com.chap04.sec4_1.SymbolGraph;

/**
 * Created by Naveen Kumar .A on 8/20/16.
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(DiGraph g) {
        DirectedCycle cycleFinder = new DirectedCycle(g);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(g);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args) {
        String fileName = "resources/";
        String sp = "";

        SymbolGraph sg = new SymbolGraph(fileName, sp);
//        Topological topo = new Topological(sg.g());

    }
}
