package com.chap2.sec_2_2;

import com.chap2.sec_2_1.AbstractSort;

import java.util.Arrays;

/**
 * Created by Naveen on 29-07-2016.
 */
public class AbstractInPlaceMerge {
    protected static Comparable[] aux;
    public static void merge(Comparable[] a, int low, int mid, int high) {
       int i = low;
        int j = mid+1;

        for (int k = low; k <=high ; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <=high ; k++) {
            if(i>mid){
                a[k] = aux[j++];
            }else if(j> high){
                a[k] = aux[i++];
            }else if(AbstractSort.less(aux[i], aux[j])){
                a[k] = aux[i++];
            }else{
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
        aux =new Comparable[a.length];
        merge(a, 0, (a.length/2)-1, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
