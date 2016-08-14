package com.chap3.sec3_4;

/**
 * Created by Naveen Kumar .A on 8/12/16.
 */
public class LinearProbingHashST<Key, Value> {

    private int n;
    private int m = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    private int hash(Key key) {
        return (31 * key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int newSize) {

    }

    public void put(Key key, Value value) {
        if (n > m / 2) {
            resize(m * 2);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m;
        while(keys[i] != null){
            Key redoKey = keys[i];
            Value redoValue = values[i];
            n--;
            put(redoKey, redoValue);
            i=(i+1)%m;
        }
        n--;
        if(n>0 && n<= m/8){
            resize(m/2);
        }
    }
}
