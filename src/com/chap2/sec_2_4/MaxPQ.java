package com.chap2.sec_2_4;

public class MaxPQ<key extends Comparable<key>> {

    private key[] pq;
    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (key[]) new Comparable[maxN];

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(key v) {
        pq[++n] = v;
        swim(n);
    }

    private boolean less(int k, int j) {
        return pq[k].compareTo(pq[j]) < 0;
    }

    private void exch(int k, int j) {
        key temp = pq[k];
        pq[k] = pq[j];
        pq[j] = temp;
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2 * k;
            if (less(j, j + 1)) {
                j = j + 1;
            }
            if (less(j, k)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

}
