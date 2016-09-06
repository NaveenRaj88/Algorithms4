package com.chap01.sec1_5;

import com.util.StdOut;
import com.util.StdRandom;
import com.util.StdStats;

/**
 * Created by Naveen Kumar .A on 9/6/16.
 */
public class PercolationStats {

    private Percolation percolation;
    private int openSites;
    private int t;
    private double[] threshold;

    public PercolationStats(int n, int trials){
        if(n<=0 || trials <=0){
            throw  new IllegalArgumentException("illegal grid size or trial size");
        }

        this.t = t;
        int randx=0,randy=0;
        for (int i = 0; i <t; i++) {
            percolation = new Percolation(n);
            while(!percolation.percolates()) {
                randx = StdRandom.uniform(1, n + 1);
                randy = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(randx, randy)) {
                    percolation.open(randx, randy);
                    openSites++;
                }
            }
            threshold[i] = openSites/(n*n);
        }
    }


    public double mean(){
        return StdStats.mean(threshold);
    }

    public double stddev() {
        return StdStats.stddev(threshold);
    }
    public double confidenceLo() {
        return mean() - (1.96*stddev())/Math.sqrt(t);
    }
    public double confidenceHi() {
        return mean() + (1.96*stddev())/Math.sqrt(t);
    }

    public static void main(String[] args) {
        int T, N;
        T = Integer.parseInt(args[0]);
        N = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(T, N);

//Instead of StdOut.println() function, you can use your own output format
        StdOut.println("%Java PercolationStats " + T + " " + N);
        StdOut.println("Mean "+percolationStats.mean());
        StdOut.println("stddev " + percolationStats.stddev());
        StdOut.println("95% confidence interval = "+ percolationStats.confidenceLo()
                + ", " + percolationStats.confidenceHi());

    }
}

