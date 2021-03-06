package com.chap2.sec_2_1;

import com.util.In;

public class SelectionSort extends AbstractSort {

    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
                exch(a, i, min);

        }
    }

    public static void main(String[] args) {
        String fileName = "resources/words3.txt";
        In in = new In(fileName);
        Comparable[] s = in.readAllStrings();
        s= "A, E, E, E, E, G, L, N, N, O, P, R, R, S, T, X".split(", ");
        new SelectionSort().sort(s);
        System.out.println("is sorted "+isSorted(s));
        show(s);

    }
}
