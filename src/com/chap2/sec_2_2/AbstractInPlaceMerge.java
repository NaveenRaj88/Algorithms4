package com.chap2.sec_2_2;

import com.chap2.sec_2_1.AbstractSort;

import java.util.Arrays;

/**
 * Created by Naveen on 29-07-2016.
 */
public class AbstractInPlaceMerge {

    public static void merge(Comparable[] a, int low, int mid, int high) {
        Comparable[] aux = new Comparable[high - low];
        int lCounter = 0;
        int rCounter = (aux.length/2);
        for (int i = 0; i < high; i++) {
            aux[i] = a[i + low];
        }
        for (int i = low; i <high; i++) {
            if (lCounter >= mid) {
                a[i] = aux[rCounter++];
            } else if (rCounter >= aux.length) {
                a[i] = aux[lCounter++];
            } else if (AbstractSort.less(aux[lCounter], aux[rCounter])) {
                a[i] = aux[lCounter++];
            } else {
                a[i] = aux[rCounter++];
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
        merge(a, 0, a.length / 2, a.length);
        System.out.println(Arrays.toString(a));
    }
}
