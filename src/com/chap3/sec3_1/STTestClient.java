package com.chap3.sec3_1;

import com.util.In;

/**
 * Created by Naveen Kumar .A on 8/8/16.
 */
public class STTestClient {

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
//        In in = new In("/resources/");
        String[] s = "SEARCHEXAMPLE".split("");
        for (int i = 0; i <s.length ; i++) {
            st.put(s[i], i);
        }

        for (String str : st.keys()){
            System.out.println(str+" "+st.get(str));
        }
    }
}
