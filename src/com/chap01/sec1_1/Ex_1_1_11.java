package com.chap01.sec1_1;

/**
 * Write a code fragment that prints the contents of a two-dimensional boolean
 * array, using '*' to represent true and a space to represent false. Include row and column
 * numbers.
 * Created by Naveen Kumar.A on 27/06/16.
 */
public class Ex_1_1_11 {

    public static void main(String[] args) {
        boolean[][] boo = new boolean[][]{{true, false, true, false}, {false, true, true, true}, {true, false, true, true}, {true, false, false, true}};
        for (int i = 0; i < boo.length; i++) {
            System.out.println();
            for (int j = 0; j < boo.length; j++) {
                System.out.print(boo[i][j] + "  ");
            }
        }
    }
}
