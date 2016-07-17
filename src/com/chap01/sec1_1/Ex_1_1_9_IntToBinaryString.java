package com.chap01.sec1_1;

/**
 * Created by Naveen Kumar .A on 7/17/16.
 */
public class Ex_1_1_9_IntToBinaryString {

    public static void main(String[] args) {
        int num = 20;
        String bin ="";
        for (int i = num; i > 0; i/=2) {
            bin = i%2 + bin;
        }
        System.out.println(bin);
    }
}
