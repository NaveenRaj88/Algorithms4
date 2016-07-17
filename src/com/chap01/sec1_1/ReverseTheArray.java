package com.chap01.sec1_1;

import com.util.ArrayGenerator;

import java.util.Arrays;

/**
 * Created by Naveen Kumar .A on 7/17/16.
 */
public class ReverseTheArray {
    public static void main(String[] args) {
        int[] a = ArrayGenerator.generateIntArray(11);
        System.out.println(Arrays.toString(a));
        int length = a.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = a[i];
            a[i] = a[length - i - 1];
            a[length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
