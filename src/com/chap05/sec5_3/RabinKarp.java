package com.chap05.sec5_3;

/**
 * Created by Naveen Kumar .A on 11/7/16.
 */
public class RabinKarp {

//    private String pat  only for las vegas

    private long patHash;

    private int m;
    private long q;
    private int r = 256;
    private long rm;

    public RabinKarp(String pattern) {
//        this.pat = pat;

        this.m = pattern.length();
        q = 997;
        rm = 1;
        for (int i = 1; i < m - 1; i++) {
            rm = (r * rm) % q;
        }
        patHash = hash(pattern, m);
    }


    private long hash(String pattern, int len) {
        long h = 0;
        for (int i = 0; i < len; i++) {
            h = (r * h + pattern.charAt(i)) % q;
        }
        return h;
    }

    private boolean check(int i) {
        return true;
    }

    private int search(String txt) {
        int n = txt.length();
        long txtHash = hash(txt, m);
        if (patHash == txtHash) {
            return 0;
        }
        for (int i = m; i < n; i++) {
            txtHash = (txtHash + q - rm * txt.charAt(i - m) % q) % q;
            txtHash = (txtHash * r + txt.charAt(i)) % q;
            if (patHash == txtHash) {
                if (check(i - m + 1)) {
                    return i - m + 1;
                }
            }
        }
        return n;
    }

}
