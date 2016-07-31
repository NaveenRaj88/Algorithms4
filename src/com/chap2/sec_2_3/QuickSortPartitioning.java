package com.chap2.sec_2_3;

import com.chap2.sec_2_1.AbstractSort;

/**
 * Created by Naveen on 31-07-2016.
 */
public class QuickSortPartitioning {

    public static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            while (AbstractSort.less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (AbstractSort.less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            AbstractSort.exch(a, i, j);
        }

        AbstractSort.exch(a, low, j);
        return j;
    }
}