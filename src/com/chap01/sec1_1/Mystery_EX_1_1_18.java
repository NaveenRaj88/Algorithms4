package com.chap01.sec1_1;

public class Mystery_EX_1_1_18 {

    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static int mysteryMul(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) + a;
    }

    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));

        System.out.println(mysteryMul(2, 25));
        System.out.println(mysteryMul(3, 11));
        System.out.println(mysteryMul(5, 11));

    }
}
