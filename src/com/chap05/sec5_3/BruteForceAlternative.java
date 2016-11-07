package com.chap05.sec5_3;

/**
 * Created by Naveen Kumar .A on 11/5/16.
 */
public class BruteForceAlternative {

    public static int search(String text, String pat) {
        int j, m = pat.length();
        int i, n = text.length();
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (text.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }

        }
        if (j == m) {
            return i - m;
        } else {
            return n;
        }
    }

}
