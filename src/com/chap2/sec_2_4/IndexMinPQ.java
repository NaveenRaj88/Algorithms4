package com.chap2.sec_2_4;

import java.util.Iterator;

/**
 * Created by Naveen Kumar .A on 10/8/16.
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements  Iterable<Integer>{

    int maxSize;
    int n;
    int pq[];
    int qp[];
    Key[] keys;

    public IndexMinPQ(int maxSize){
        maxSize = maxSize;
        n =0;
        keys = (Key[]) new Comparable[maxSize +1];
        pq = new int[maxSize+1];
        qp= new int[maxSize+1];
        for (int i = 0; i <=maxSize ; i++) {
            qp[i] = -1;
        }
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean contains(int k){
            if(k<0 || k >= maxSize){
                throw new IllegalArgumentException();
            }
        return qp[k] != -1;
    }

    public int size(){
        return  n;
    }

    public void insert(int i, Key key){
        if(i< 0 || i>= maxSize){
            throw new IllegalArgumentException();
        }
        if(contains(i)){
            throw new IllegalArgumentException("index is already in priority queue");
        }
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;

    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
