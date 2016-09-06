package com.chap05.sec5_3;

/**
 * Created by Naveen Kumar .A on 9/1/16.
 */
public class BFExplicitBackupSubStringSearch {

    public static int search(String pat, String text){

        int  n = text.length();
        int  m = pat.length();
        int i ,j;
        for ( i = 0, j=0; i <n && j < m; i++) {
            if(text.charAt(i) == pat.charAt(j)){
                j++;
            }else{
                i -=j;
                j=0;
            }
        }
        if(j == m){
            return i;
        }
        return n;
    }
}
