package com.chap2.sec_2_2;

import java.util.Arrays;

/**
 * Created by Naveen on 30-07-2016.
 */
public class BottomUpMergeSort extends AbstractInPlaceMerge {

    public void sort1(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int i = 1; i < n; i += i) {
            for (int j = 0; j < n - i; j += i + i) {
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, n - 1));
            }
        }
    }


    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int n = a.length;
        for (int i = 1; i < n; i = 2 * i) {
            for (int j = 0; j < n - i; j = j + 2 * i) {
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = "MERGESORTEXAMPLE".split("");
        System.out.println(Arrays.toString(a));
        BottomUpMergeSort bs = new BottomUpMergeSort();
        bs.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
