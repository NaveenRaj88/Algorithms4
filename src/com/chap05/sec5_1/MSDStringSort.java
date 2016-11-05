package com.chap05.sec5_1;

import com.chap2.sec_2_1.AbstractSort;

import java.util.Arrays;

/**
 * Created by Naveen Kumar .A on 8/29/16.
 */
public class MSDStringSort {

    private static int r = 256;

    private static final int m = 3;

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

    private static void insertionSort(String[] a, int low, int high, int d) {
        System.out.println(low +" "+high);
        for (int i = low; i <= high; i++) {
            System.out.println(i);
            for (int j = i; j > low && less(a[j], a[j - 1], d); j--) {
                System.out.println(j);
                AbstractSort.exch(a, j - 1, j);
            }
        }
    }

    private static boolean less(String a, String b, int d){
        return a.substring(d).compareTo(b.substring(d)) < 0;
    }

    private static void sort(String[] a, int low, int high, int d) {
        if (high <= low + m) {
            insertionSort(a, low, high, d);
            return;
        }
        int[] count = new int[r + 2];

        for (int i = low; i <= high; i++) {
            count[charAt(a[i],d) + 2]++;
        }

        for (int i = 0; i < r + 1; i++) {
            count[i + 1] += count[i];
        }

        for (int i = 0; i <= high; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = low; i <= high; i++) {
            a[i] = aux[i - low];
        }

        for (int i = 0; i < r; i++) {
            sort(a, low + count[i], low + count[i + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = {"she","sells","seashells","by","the","sea","shore","the","shells","she","sells","are","surely","seashells"};
        sort(a);
        System.out.println(Arrays.toString(a));

    }

}
