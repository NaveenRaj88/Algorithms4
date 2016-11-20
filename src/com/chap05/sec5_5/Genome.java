package com.chap05.sec5_5;

import com.chap05.sec5_1.Alphabet;
import com.util.BinaryStdIn;
import com.util.BinaryStdOut;
import com.util.In;
//import edu.princeton.cs.algs4.BinaryStdIn;
//import edu.princeton.cs.algs4.BinaryStdOut;
//import edu.princeton.cs.algs4.In;

/**
 * Created by Naveen Kumar .A on 11/10/16.
 */
public class Genome {


    public static void compress(String s){
        Alphabet DNA  = new Alphabet("ACTG");
        int n = s.length();
        BinaryStdOut.write(n);
        for (int i = 0; i <n ; i++) {
            int d = DNA.toindex(s.charAt(i));
            BinaryStdOut.write(d,DNA.lgr());
        }
        BinaryStdOut.close();
    }

    public static void expand(){
        Alphabet DNA  = new Alphabet("ACTG");
        int w = DNA.lgr();
        int n =BinaryStdIn.readInt();
        for(int i =0; i <n ;i++){
            char c = BinaryStdIn.readChar(w);
            BinaryStdOut.write(DNA.toChar(c));
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        In in = new In("resources/genomeTiny.txt");
        String s = in.readString();
        compress(s);
        expand();


    }
}
