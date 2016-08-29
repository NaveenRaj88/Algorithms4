package com.chap05.sec5_2;

import com.chap01.sec1_3.Queue;
import com.chap3.sec3_1.BinarySearchST;
import com.chap3.sec3_1.SequentialSearchST;

/**
 * Created by Naveen Kumar .A on 8/29/16.
 */
public class StringST<Value> extends SequentialSearchST<String, Value>{

        public StringST(){

        }

    public boolean isEmpty(){
        return size() ==0;
    }

    public String longestPrefixOf(String s){

        return null;
    }

    public Iterable<String> keysWithPrefix(String s){
        Queue<String> queue = new Queue<>();
        for (String str : keys()){
            if(str.startsWith(s)){
                queue.enqueue(str);
            }
        }
        return queue;
    }


    public Iterable<String> keysThatMatch(String s){
        Queue<String> queue = new Queue<>();
        for (String str : keys()){
            if(str.equals(s)){
                queue.enqueue(str);
            }
        }
            return queue;
    }

}
