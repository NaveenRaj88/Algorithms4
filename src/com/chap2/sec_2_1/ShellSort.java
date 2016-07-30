package com.chap2.sec_2_1;

import com.util.In;

public class ShellSort extends AbstractSort {

    public void sort(Comparable[] a) { // Sort a[] into increasing order.
        int n = a.length;
        for (int h = n / 4; h > 0; h = h / 2) {
            int i = h;
            for (int j = 0;i<n; j++,i++) {
                int start = j;
                int end = i;
                while (start >=0  && less(a[end], a[start])) {
                    exch(a, end, start);
                    end = start;
                    start = end-h;
                }
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "resources/words3.txt";
        In in = new In(fileName);
        Comparable[] s = in.readAllStrings();
        show(s);
        new InsertionSort().sort(s);
        System.out.println(isSorted(s));
        show(s);
    }
}
