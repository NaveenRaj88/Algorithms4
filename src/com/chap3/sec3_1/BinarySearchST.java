package com.chap3.sec3_1;

import com.chap01.sec1_3.Queue;

/**
 * Created by Naveen on 08-08-2016.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        n=0;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[n-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public boolean contains(Key key){
        int i = rank(key);
        return key.compareTo(keys[i]) ==0;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int i =  rank(key);
        if(i < n && keys[i].compareTo(key) ==0){
            return values[i];
        }
        return null;
    }

    public void put(Key key, Value value){
        int i = rank(key);
        if(i<n && key.compareTo(key) ==0){
            values[i] = value;
        }else{
            for(int j=n;j>i;j--){
                keys[n] = keys[n-1];
                values[n] = values[n-1];
            }
            keys[i] = key;
            values[i] = value;
            n++;
        }
    }

    public int rank(Key key){
        return rank(key, 0, n);
    }

    public Key ceiling(Key key){
       int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        return keys[i];
    }


    public Iterable<Key> keys(Key low, Key high){
        Queue<Key> q = new Queue<>();
        for (int i = rank(low); i < rank(high); i++) {
            q.enqueue(keys[i]);
        }
        if(contains(high)){
            q.enqueue(high);
        }
        return q;
    }

    private int rank(Key key, int low, int high){
        if(high < low){
            return low;
        }
        int mid = (low+high)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp <1){
            return rank(key, low, mid-1);
        }else if(cmp >1){
            return rank(key, mid+1, high);
        }else{
            return mid;
        }

    }
    public static void main(String[] args) {

    }
}
