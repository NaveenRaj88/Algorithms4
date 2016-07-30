package com.chap2.sec_2_1;

import com.util.StdRandom;
import com.util.Stopwatch;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equalsIgnoreCase("Insertion"))
            new InsertionSort().sort(a);
        if (alg.equalsIgnoreCase("Selection"))
            new SelectionSort().sort(a);
        if (alg.equalsIgnoreCase("Shell")) {
            new ShellSort().sort(a);
        }
        // if (alg.equals("Merge")) Merge.sort(a);
        // if (alg.equals("Quick")) Quick.sort(a);
        // if (alg.equals("Heap")) Heap.sort(a);
        double timerElapsed = timer.elapsedTime();
        return timerElapsed;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
            if (!AbstractSort.isSorted(a)) {
                throw new RuntimeException("array not sorted");
            }
        }
        return total;
    }

    public static void main(String[] args) {

        String alg1 = "Selection"; //args[0];
        String alg2 = "Insertion"; //args[1]
        String alg3 = "Shell";
        int N = 1000;
        int T = 200;
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        double t3 = timeRandomInput(alg3, N, T); // total for alg2
        System.out.println("Total times  of the algorithms "+t1+" ,"+ t2+"  , " +t3);
//        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
//        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
