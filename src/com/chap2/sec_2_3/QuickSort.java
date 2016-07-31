package com.chap2.sec_2_3;

import com.util.StdRandom;

import java.util.Arrays;

/**
 * Created by Naveen on 31-07-2016.
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = QuickSortPartitioning.partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    public static void main(String[] args) {
        Comparable[] a = "Q U I C K S O R T E X A M P L E".split(" ");
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}