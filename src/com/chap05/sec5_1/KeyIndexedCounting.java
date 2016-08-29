package com.chap05.sec5_1;

/**
 * Created by Naveen Kumar .A on 8/26/16.
 */
public class KeyIndexedCounting {


    public static void sort(School[] sk){
        int[] count = new int[6];
        for (int i = 0; i <sk.length ; i++) {
            count[sk[i].key+1]++;
        }
        for (int i = 0; i <count.length-1 ; i++) {
            count[i+1] += count[i];
        }
        School[] aux = new School[sk.length];
        for (int i = 0; i <sk.length ; i++) {
            aux[count[sk[i].key]++] = sk[i];
        }
        for (int i = 0; i <aux.length ; i++) {
            sk[i] = aux[i];
        }

        for (School s : sk){
            System.out.println(s.name+" "+s.key);
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
    }

    private static class School{
        public String name;
        public int key;

        public School(String name, int key) {
            this.name = name;
            this.key = key;
        }
    }
}
