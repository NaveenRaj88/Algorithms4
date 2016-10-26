package com.chap04.sec4_1;

import com.chap3.sec3_1.SequentialSearchST;
import com.util.In;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Naveen Kumar .A on 8/15/16.
 */
public class SymbolGraph {

    private SequentialSearchST<String, Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String stream, String sp) {
        st = new SequentialSearchST<>();
        In in = new In(stream);
        String[] a = in.readAll().split(sp);
        for (int i = 0; i < a.length; i++) {
            if (!st.contains(a[i])) {
                st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()];
        for (String s : st.keys()) {
            keys[st.get(s)] = s;
        }

        g = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                g.addEdge(v, st.get(a[i]));
            }
        }

    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph g() {
        return g;
    }

//    public static void main(String[] args) {
//        TreeMap<String, Object> tm = new TreeMap<>(new objComparator());
//        tm.put("1976", "1976");
//        tm.put("1875", "1875");
//        tm.put("2076", "2076");
//        tm.put("2000", "2000");
//        tm.put(null, null);
//        System.out.println(tm);
//    }


}

// class objComparator implements Comparator<String>{
//public int compare(String obj1, String obj2) {
//        if (obj1 == null) {
//        return 1;
//        } else if (obj2 == null) {
//        return -1;
//        }
//        return obj2.compareTo(obj1);
//        }
//        }
