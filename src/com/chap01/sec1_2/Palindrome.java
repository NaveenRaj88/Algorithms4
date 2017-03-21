package com.chap01.sec1_2;

/**
 * Created by Naveen on 20-07-2016.
 */
public class Palindrome {

    public static boolean isPalindrome(String input){
        int length = input.length();
        for(int i =0; i<length/2; i++){
            if(input.charAt(i) != input.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("malaalam"));
    }
}