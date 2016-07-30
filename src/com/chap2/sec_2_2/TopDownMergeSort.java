package com.chap2.sec_2_2;

import java.util.Arrays;

/**
 * Created by Naveen on 30-07-2016.
 */
public class TopDownMergeSort extends AbstractInPlaceMerge{

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[]  a, int low, int high){
        if(high <= low){
            return;
        }
        int mid = low+(high-low)/2;
        sort(a,low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }
    public static void main(String[] args) {
        Comparable[] a = "MERGESORTEXAMPLE".split("");
        System.out.println(Arrays.toString(a));
           sort(a);

        System.out.println(Arrays.toString(a));
    }
}
