package com.chap04;

/**
 * Created by Naveen Kumar .A on 8/14/16.
 */
public class GraphUtil {

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (Integer i : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g) {
        int maxDegree = 0;
        for (int i = 0; i < g.v(); i++) {
            int degree = degree(g, i);
            if (degree > maxDegree) {
                maxDegree = i;
            }
        }
        return maxDegree;
    }

    public static int avgDegree(Graph g) {
        return 2 * g.e() / g.v();
    }

    public static int selfLoops(Graph g) {
        int count = 0;
        for (int i = 0; i < g.v(); i++) {
            for (int j : g.adj(i)) {
                if (i == j) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public static String toString(Graph g) {
        String s = g.v() + " Vertices" + g.e() + " Edges\n";
        for (int i = 0; i < g.v(); i++) {
            s += i + ": ";
            for (int j : g.adj(i)) {
                s += j + " ";
            }
            s += "\n";
        }
        return s;
    }
}
