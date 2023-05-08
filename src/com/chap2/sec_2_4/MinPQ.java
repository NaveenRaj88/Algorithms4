package com.chap2.sec_2_4;

public class MinPQ<key extends Comparable<key>> {

   private  key[] pq;
    private int n;

    public MinPQ()
    {

    }
    public MinPQ(int n){
       this.n =n;
        pq = (key[]) new Object[n];
    }

    public boolean isEmpty(){
        return n == 0;
    }
    public key delMin(){
        return pq[1];
    }

    public int size(){
        return n;
    }
    public void insert(key k){

    }

    private boolean less(int i , int j){
        return pq[i].compareTo(pq[j]) <0;
    }
    private void exch(int i, int j){
        key key = pq[i];
        pq[i] = pq[j];
        pq[j] = key;
    }

    private void swim(int k){
        while(k >1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <=n){
            int j = 2*k;
            if(j < n && less (j, j+1)){
                j++;
            }
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

    private void sink1(int k){
        while(k<=n){
            int j = 2*k;
            if(j <=n && less(j, j+1)) {
                j++;
            }
            if(less(j,k)) {
                break;
            }
            exch(k,j);
            k=j;
        }
    }
}
