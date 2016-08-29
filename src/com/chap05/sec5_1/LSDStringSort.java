package com.chap05.sec5_1;

/**
 * Created by Naveen Kumar .A on 8/26/16.
 */
public class LSDStringSort {

    public static void sort(String[] a, int w){
        int n = a.length;
        int r = 256;
        String[] aux = new String[n];

        for (int i = w-1; i >=0 ; i++) {
            int[] count = new int[r];

            for (int j = 0; j <n ; j++) {
                count[a[j].charAt(i)+1]++;
            }

            for (int j = 0; j <r-1 ; j++) {
                count[j+1] += count[j];
            }
            for (int j = 0; j <n ; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            for (int j = 0; j < n; j++) {
                a[j]=aux[j];
            }
        }
        
    }
}
