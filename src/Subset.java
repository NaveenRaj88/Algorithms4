import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * Created by Naveen Kumar .A on 9/6/16.
 */
public class Subset {

    public static void main(String[] args) {
        String[] str = StdIn.readAllStrings();
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        for (String st : str){
            randomizedQueue.enqueue(st);
        }

        if(args.length <1){
            throw new IllegalArgumentException("invalid argument");
        }
        int length = Integer.parseInt(args[0]);
        for (int i=0; i <length ; i++) {
            randomizedQueue.dequeue();
        }
    }
}
