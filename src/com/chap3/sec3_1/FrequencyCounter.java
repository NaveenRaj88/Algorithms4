package com.chap3.sec3_1;

import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/8/16.
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minLength = 8;
        SequentialSearchST<String, Integer> st = new SequentialSearchST();
        In in = new In("/resources/tinyTale.txt");
        String[] strings = in.readAllStrings();
        for (String s : strings){
            if(s.length() < minLength){
                continue;
            }
            if(st.contains(s)){
                st.put(s, st.get(s)+1);
            }else{
                st.put(s,1);
            }
        }

        // Find max words
        int max =0;
        for(String str : st.keys()){

        }
    }
}
