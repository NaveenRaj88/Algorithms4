package com.chap2.sec_2_4;

import com.chap2.sec_2_1.AbstractSort;

/**
 * Created by Naveen Kumar .A on 8/1/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int size = 0;

    public MaxPQ(int maxSize) {
        pq = (Key[]) new Comparable[maxSize + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key v) {
        pq[++size] = v;
        swim(size);
    }

    public Key delMax(){
        Key v = pq[1];
        AbstractSort.exch(pq, 1, size);
        size--;
        sink(1);
        return v;
    }

    public void swim(int k){
        while(k>1 && AbstractSort.less(pq[k/2], pq[k])){
            AbstractSort.exch(pq, k,k/2);
            k=k/2;
        }
    }

    public void sink(int k){
        while(size >= 2*k){
            int j = 2*k;
            if(j<size && AbstractSort.less(pq[j], pq[j+1])){
                j++;
            }else if(AbstractSort.less(pq[j], pq[k])){
                break;
            }
            AbstractSort.exch(pq, k,j);
            k=j;
        }
    }

}
