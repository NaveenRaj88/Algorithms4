package com.chap05.sec5_1;

import java.util.Arrays;

/**
 * Created by Naveen Kumar .A on 8/26/16.
 */
public class LSDStringSort {

    public static void sort(String[] a, int w){
       int n = a.length;
        String[] aux = new String[n];
        int r = 256;
        int[] count;

        for (int i = w-1; i >=0 ; i--) {
           count =  new int[r+1];
            for (int j = 0; j <n ; j++) {
                count[1+a[j].charAt(i)]++;
            }

            for (int j = 0; j <r ; j++) {
                count[j+1] += count[j];
            }

            for (int j = 0; j <n ; j++) {
                System.out.println(i +" "+ j);
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            for (int j = 0; j <n ; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"4PGC938","2IYE230","3CIO720","1ICK750","1OHV845","4JZY524","1ICK750","3CIO720","1OHV845","1OHV845","2RLA629","2RLA629","3ATW723"};
        sort(a,7);
        System.out.println(Arrays.toString(a));
    }
}
