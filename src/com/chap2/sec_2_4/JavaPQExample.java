package com.chap2.sec_2_4;

import java.util.Collections;
import java.util.PriorityQueue;

public class JavaPQExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(1);
        pq.add(18);
        pq.add(6);
        pq.add(8);
        for (Integer i: pq) {
            System.out.println(i);
        }
    }
}
