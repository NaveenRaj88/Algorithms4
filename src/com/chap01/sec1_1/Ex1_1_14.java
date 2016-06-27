package com.chap01.sec1_1;

/**
 * Write a static method lg() that takes an int value N as argument and returns
 * the largest int not larger than the base-2 logarithm of N. Do not use Math.
 *
 * Created by Naveen Kumar.A on 27/06/16.
 */
public class Ex1_1_14 {

    public static int lg(int n){
        int i =0;
        int logVal =1;
        while(logVal*2 <= n){
            logVal = logVal*2;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(Math.log(8));
        System.out.println(lg(16));
    }
}
