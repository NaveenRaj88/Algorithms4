package com.chap05.sec5_1;

import com.chap2.sec_2_1.InsertionSort;

/**
 * Created by Naveen Kumar .A on 8/29/16.
 */
public class MSDStringSort {

    private static int r = 256;

    private static final int m = 15;

    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[n];
        sort(a, 0, n - 1, 0);
    }

    private static void sort(String[] a, int low, int high, int d) {
        if(high <= low+m){
            InsertionSort.sortArray(a);
            return;
        }
        int[] count = new int[r+2];

        for (int i = low; i <= high ; i++) {
            count[charAt(a[i],d)+2]++;
        }
        for (int i = 0; i < r+1; i++) {
            count[i+1] += count[i];
        }

        for (int i = low; i <= high ; i++) {
            aux[count[charAt(a[i], d)+1]++] = a[i];
        }

        for (int i = low; i <=high ; i++) {
            a[i] = aux[i-low];
        }

        for (int i = 0; i < r; i++) {
            sort(a, low+count[r], low+count[r+1]-1, d+1);
        }
    }

}
