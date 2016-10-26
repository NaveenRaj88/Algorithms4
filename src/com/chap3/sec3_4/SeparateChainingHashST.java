package com.chap3.sec3_4;

import com.chap3.sec3_1.SequentialSearchST;

/**
 * Created by Naveen Kumar .A on 8/12/16.
 */
public class SeparateChainingHashST<Key, Value> {

    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public boolean contains(Key key) {
        if (key == null) {
            return false;
        }
        return get(key) != null;
    }
}
