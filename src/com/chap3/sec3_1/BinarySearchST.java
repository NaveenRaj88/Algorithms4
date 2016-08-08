package com.chap3.sec3_1;

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
