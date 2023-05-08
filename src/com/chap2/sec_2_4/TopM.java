package com.chap2.sec_2_4;

import com.collections.Stack;
import com.util.StdIn;
import com.util.Transaction;

public class TopM {

    public static void main(String[] args) {
        int m  = Integer.parseInt(args[0]);
        MinPQ pq = new MinPQ(m+1);
        while(StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size()> m){
                pq.delMin();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while(!pq.isEmpty()){
        stack.push((Transaction) pq.delMin());
        }
        for(Transaction t: stack){
            System.out.println(t);
        }
    }
}
