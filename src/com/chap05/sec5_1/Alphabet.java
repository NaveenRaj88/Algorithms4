package com.chap05.sec5_1;

/**
 * Created by Naveen Kumar .A on 8/23/16.
 */
public class Alphabet {

    private char[] alpChar;

    private int radix;

    public Alphabet(String s) {
        this.alpChar = s.toCharArray();
        radix = alpChar.length;
    }

    public char toChar(int index) {
        return alpChar[index];
    }

    public int toindex(char c) {
        for (int i = 0; i < alpChar.length; i++) {
            if (alpChar[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(char c) {
        return toindex(c) != -1;
    }

    public int radix() {
        return radix;
    }

    public int lgr() {
        int lgr = 0;
        for (int i = radix - 1; i >= 1; i /= 2) {
            lgr++;
        }
        return lgr;
    }

    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            target[i] = toindex(source[i]);
        }
        return target;
    }

    public String toChars(int[] indices) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            st.append(toChar(indices[i]));
        }
        return st.toString();
    }
}
