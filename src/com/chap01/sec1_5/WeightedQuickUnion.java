package com.chap01.sec1_5;

import com.util.In;

public class WeightedQuickUnion extends UF {

    private int[] sz;

    public WeightedQuickUnion(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public static void main(String[] args) {
        int[] a = new In("resources/tinyUf.txt").readAllInts();
        int index = 0;
        WeightedQuickUnion qu = new WeightedQuickUnion(a[index++]);
        while (index < a.length) {
            int p = a[index++];
            int q = a[index++];
            if (qu.connected(p, q)) {
                continue;
            }
            qu.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(qu.count + " components");
    }
}