package com.chap3.sec3_1;

/**
 * Created by Naveen on 08-08-2016.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val){
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) ==0){
            vals[i] = val;
            return;
        }
        for(int j = n; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i]= key;
        vals[i] = val;
        n++;
    }
    public void delete(Key key){
        int i = rank(key);
        if(keys[i].compareTo(key) ==0){
            while(i< n){
                keys[i] = keys[i+1];
                vals[i] = vals[i+1];
                i++;
            }
            n--;
        }
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }
    public Key floor(Key key){
        int i = rank(key);
        if(keys[i].compareTo(key) == 0){
            return keys[i];
        }else{
            return keys[i+1];
        }
    }

    public int rank(Key key){
        return rank(key, 0, n-1);
    }

    public int rank(Key key, int low, int high){
        if(high < low){
            return low;
        }
        int mid = low+ (high-low)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0 ){
            return rank(key, low, mid-1);
        }else if(cmp >0){
            return rank(key, mid+1, high);
        }else return mid;
    }



    public static void main(String[] args) {

    }
}
