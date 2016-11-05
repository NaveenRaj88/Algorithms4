package com.chap05.sec5_1;

import java.util.Arrays;

/**
 * Created by Naveen Kumar .A on 8/26/16.
 */
public class KeyIndexedCounting {


    public static void sort(School[] sk){
        int r = 5;
        int n = sk. length;
        int[] count = new int[r+1];
        School[] aux = new School[n];
        
        //compute the frequencies
        for (int i = 0; i < n; i++) {
            count[sk[i].key+1]++;
        }
        // transform count to indices
        for (int i = 0; i <r ; i++) {
            count[i+1] += count[i];
        }
        // Distribute the records
        for (int i = 0; i < n; i++) {
            aux[count[sk[i].key]++] = sk[i];
        }

        // copy back the records
        for (int i = 0; i < n; i++) {
            sk[i]= aux[i];
        }
    }

    public static void main(String[] args) {
        School[] sc = new School[7];
        sc[0] = new School("Anderson" ,2);
        sc[1] = new School("Brown" ,3);
        sc[2] = new School("Davis" ,3);
        sc[3] = new School("Garcia" ,4);
        sc[4] = new School("Harris" ,1);
        sc[5] = new School("Jackson" ,3);
        sc[6] = new School("Johnson" ,4);
        sort(sc);
        System.out.println(Arrays.toString(sc));
    }

    private static class School{
        public String name;
        public int key;

        public School(String name, int key) {
            this.name = name;
            this.key = key;
        }

        @Override
        public String toString() {
            return name +"->"+key;
        }
    }
}
