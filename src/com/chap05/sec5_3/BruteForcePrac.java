package com.chap05.sec5_3;

/**
 * Created by Naveen Kumar .A on 11/9/16.
 */
public class BruteForcePrac {

    public int search(String text, String pat){
        int n = text.length();
        int m = pat.length();
        for (int i = 0; i <n-m ; i++) {

            int j =0;
            for (j = 0; j <m ; j++) {
                if(text.charAt(i+j) != pat.charAt(j)){
                    break;
                }
            }
            if(j == m){
                return i;
            }
        }
        return n;
    }
}
