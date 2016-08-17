package com.chap04.sec4_1;

import com.chap3.sec3_1.BinarySearchST;
import com.chap3.sec3_1.SequentialSearchST;
import com.sun.java_cup.internal.runtime.Symbol;
import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class SymbolGraph {

    private SequentialSearchST<String, Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String stream, String sp){
        st = new SequentialSearchST<>();
        In in = new In(stream);
        String[] a = in.readAll().split(sp);
        for(int i =0; i< a.length;i++){
            if(!st.contains(a[i])){
                st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()];
        for(String s : st.keys()){
            keys[st.get(s)] = s;
        }

        g = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()){
            a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                g.addEdge(v, st.get(a[i]));
            }
        }

    }

    public boolean contains(String s){
        return st.contains(s);
    }

    public int index(String s){
       return st.get(s);
    }

    public String name(int v){
       return keys[v];
    }

    public Graph g(){
        return g;
    }
}
