package com.chap2.sec_2_4;

import com.chap2.sec_2_1.AbstractSort;

/**
 * Created by Naveen Kumar .A on 8/3/16.
 */
public class HeapDSVerifier {

    public static boolean certify(Comparable[] a, int k) {
        if (k > a.length) {
            return true;
        }
        int i = 2 * k;
        int j = i + 1;

        if (i < a.length && AbstractSort.less(a[k], a[i])) {
            return false;
        }
        if (j < a.length && AbstractSort.less(a[k], a[j])) {

            return false;
        }
        return certify(a, i) && certify(a, j);
    }

    public static void main(String[] args) {
        Comparable[] a = {0, 8, 7, 5, 1, 3, 4, 2};
        System.out.println(certify(a, 1));
    }
}
