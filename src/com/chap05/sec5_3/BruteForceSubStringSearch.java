package com.chap05.sec5_3;

import java.util.Stack;

/**
 * Created by Naveen Kumar .A on 9/1/16.
 */
public class BruteForceSubStringSearch {

    public static int search(String pat, String text){
        int m = pat.length();
        int n= text.length();

        for (int i = 0; i <= n-m ; i++) {
            int j;
            for (j = 0; j <m ; j++) {
                if(text.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if(j ==m){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(search("AB", "SAB"));
    }

}
