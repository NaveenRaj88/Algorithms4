package com.chap2.sec_2_1;

import com.util.In;

public class InsertionSort extends AbstractSort {


    public static void sort1(Comparable[] a){
        int n = a.length;
        for (int i = 1; i <n ; i++) {
            for (int j = i-1; j >= 0 && less( a[j+1], a[j]) ; j--) {
                exch(a, j, j+1);
            }
        }
    }

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            int n = i - 1;
            while (n >= 0 && less(a[n+1], a[n])) {
                exch(a, n, n + 1);
                n--;
            }
        }
    }

    public static void sortArray(Comparable[] a){
        new InsertionSort().sort(a);
    }

    public static void main(String[] args) {
        String fileName = "resources/words3.txt";
        In in = new In(fileName);
        Comparable[] s = in.readAllStrings();
        show(s);
//        new InsertionSort().sort(s);
        sort1(s);
        System.out.println(isSorted(s));
        show(s);
    }
}
