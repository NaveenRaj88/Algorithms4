package com.chap01.sec1_3;

import com.util.In;
import com.util.StdIn;
import com.util.StdOut;

/**
 * Created by Naveen Kumar .A on 7/23/16.
 */
public class FixedCapacityStackOfStrings {

    private String[] sArr;

    private int n;

    public FixedCapacityStackOfStrings(int i){
        sArr = new String[i];
    }

    public void push(String str){
        if(!isFull()){
            sArr[n++] = str;
        }
    }

    public String pop(){
        return sArr[--n];
    }

    public boolean isFull(){
        return sArr.length == n-1;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        In in = new In("resources/tobe.txt");
        while (!in.isEmpty())
        {
            String item = in.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
