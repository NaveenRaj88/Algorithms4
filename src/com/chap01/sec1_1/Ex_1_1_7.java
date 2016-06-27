package com.chap01.sec1_1;

import com.util.StdOut;

/**
 * Give the value printed by each of the following code fragments:
 *
 * Created by Naveen Kumar.A on 27/06/16.
 */
public class Ex_1_1_7 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

        System.out.println('b' +'c');
    }
}
