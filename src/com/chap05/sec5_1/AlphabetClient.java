package com.chap05.sec5_1;

import com.util.In;
import com.util.StdIn;

/**
 * Created by Naveen Kumar .A on 8/23/16.
 */
public class AlphabetClient {

    public static void main(String[] args) {
        In in = new In("resources/abra.txt");
        Alphabet alpha = new Alphabet("ABCDR");
        int r = alpha.radix();
        int[] count = new int[r];
        String s = in.readString();
        int n = s.length();
        for(int i =0; i <n;i++){
            if(alpha.contains(s.charAt(i))){
                count[alpha.toindex(s.charAt(i))]++;
            }
        }

        for (int i = 0; i <r ; i++) {
            System.out.println(alpha.toChar(i)+" "+count[i]);
        }
    }
}
