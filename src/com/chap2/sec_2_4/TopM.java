package com.chap2.sec_2_4;

import com.chap01.sec1_3.Stack;
import com.util.In;
import com.util.Transaction;

/**
 * Created by Naveen Kumar .A on 8/1/16.
 */
public class TopM {

    public static void main(String[] args) {
        int maxSize = 30;
        In in = new In("/resources/tinyBatch.txt");
//        MinPQ<Transaction> pq = new MinPQ<>(maxSize+1);
//        while(in.hasNextLine()){
//        pq.insert(new Transaction(in.readLine()));
//         if(pq.size()>maxSize){
//             pq.delMin();
//         }
//        }
//        Stack<Transaction> stack = new Stack<>();
//        While(!pq.isEmpty()){
//            stack.push(pq.delMin());
//        }
//        for(Transaction transaction : stack){
//            System.out.println(transaction);
//        }
    }
}
