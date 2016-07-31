package com.chap2.sec_2_2;


import com.chap01.sec1_3.Queue;

/**
 * Created by Naveen on 31-07-2016.
 */
public class MergeSortedQueues_EX_2_2_14 {

    public Queue<Comparable> merge(Queue<Comparable> q1, Queue<Comparable> q2) {
        Queue<Comparable> finalQueue = new Queue<>();
        Comparable temp1 = q1.dequeue();
        Comparable temp2 = q2.dequeue();
        while (temp1 != null && temp2 != null) {
            if (less(temp1, temp2)) {
                finalQueue.enqueue(temp1);
                temp1 = q1.dequeue();
            } else {
                finalQueue.enqueue(temp2);
                temp2 = q2.dequeue();
            }
        }

        while (!q1.isEmpty()) {
            if (temp1 != null) {
                finalQueue.enqueue(temp1);
            }
            finalQueue.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            if (temp2 != null) {
                finalQueue.enqueue(temp2);
            }
            finalQueue.enqueue(q2.dequeue());
        }
        return finalQueue;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Queue<Comparable> q1 = new Queue<>();
        for (String s : "A, E".split(", ")) {
            q1.enqueue(s);
        }
        Queue<Comparable> q2 = new Queue<>();
        for (String s : "T, X".split(", ")) {
            q2.enqueue(s);
        }
        MergeSortedQueues_EX_2_2_14 mergeSortedQueues = new MergeSortedQueues_EX_2_2_14();
        Queue<Comparable> finalQueue = mergeSortedQueues.merge(q1, q2);
        for (Comparable comp : finalQueue) {
            System.out.println(comp);
        }
    }
}