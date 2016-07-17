package com.chap01.sec1_1;

public class Ex_1_1_14_LogOfN {

    public static void main(String[] args) {
        System.out.println(getBase2Log(64));
    }

    public static int getBase2Log(int n) {
        int lg = 0;
        int temp = 2;
        while (true) {
            if (temp > n) {
                break;
            } else {
                temp = temp * 2;
                lg++;
            }
        }
        return lg;
    }
}
