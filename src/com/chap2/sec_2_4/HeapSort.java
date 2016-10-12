package com.chap2.sec_2_4;

import com.chap2.sec_2_1.AbstractSort;

import java.util.Arrays;

/**
 * Created by Naveen Kumar .A on 10/10/16.
 */
public class HeapSort {

    public void sort(Comparable[] c) {
        int n = c.length-1;
        for (int i = n / 2; i >= 1; i--) {
            sink(c, i, n);
        }
        while(n>=1){
            AbstractSort.exch(c, 1, n--);
            sink(c,1, n);
        }
    }

    public void sink(Comparable[] c, int k, int n) {
        while (n >= 2 * k) {
            int j = 2 * k;
            if (j < n && AbstractSort.less(c[j], c[j + 1])) {
                j++;
            }
            if (AbstractSort.less(c[j], c[k])) {
                break;
            }
            AbstractSort.exch(c, k,j);
            k = j;
        }
    }


    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        Comparable[] c =  "_SORTEXAMPLE".split("");
        hs.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
