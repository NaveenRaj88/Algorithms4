package com.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ArrayGenerator {
	static Random r = new Random();
	public static int[] generateIntArray(int size){
		int[] i = new int[size];
		for (int j = 0; j < size; j++) {
			i[j] = r.nextInt(47);
		}
		return i;
	}
	
	public static int[] generatePosAndNegArray(int size){
		int[] i = new int[size];
		int j = 0;
		Random r = new Random();
		while(j<size){
			i[j]= (int) r.nextGaussian()*10;
			j++;
		}
		return i;
	}
	
	public static int[] generateIntArray(int size, int range){
		int[] i = new int[size];
		for (int j = 0; j < size; j++) {
			i[j] = r.nextInt(range);
		}
		return i;
	}
	
	public static int[] generateIntArrayNoDuplicates(int size){
		Set<Integer> s = new HashSet<Integer>();
		int position = 0;
		while(s.size()<size){
			s.add(r.nextInt(47));
		}
		int[] i = new int[s.size()];
		for (Iterator<Integer> iterator = s.iterator(); iterator.hasNext();) {
			i[position] = iterator.next();
			position++;
		}
		return i;
	}
	
	public static int[][] generate2DimensionalArray(int rows, int col){
		int[][] a = new int [rows][col];
		for (int[] is : a) {
			for (int j = 0; j < is.length; j++) {
				is[j] = r.nextInt(47);
			}
		}
		return a;
	}
	
	public static double[] generateDoubleArray(int size){
		double[] d = new double[size];
		for (int i = 0; i < d.length; i++) {
			d[i] = r.nextDouble() * 47;
		}
		return d;
	}
	
	public static double[] generateDoubleArray(int size, int range){
		double[] d = new double[size];
		for (int i = 0; i < d.length; i++) {
			d[i] = Math.random() * r.nextInt(range);
		}
		return d;
	}
	
	public static Integer[] wrapperIntArray(int size){
		Integer[] a = new Integer[size];
		for (int i = 0; i < a.length; i++) {
			a[i]=r.nextInt(47);
		}
		return a;
	}
	
	public static int[] generateAscendingIntArray(int size){
		int[] i = generateIntArray(size);
		Arrays.sort(i);
		return i;
	}
	
	public static int[] generateAscendingIntArrayWithDuplicates(int size) {
		int[] i = new int[size];
		int random =0;
		for (int j = 0; j < i.length; j++) {
			random = (int) r.nextInt(47);
			while(random == 0 ){
				random = (int) r.nextInt(47);
			}
			i[j] = random;
			 random = (int) r.nextInt(10);
			if (random < i.length - j) {
				 while(random > 0){
					 j++;
					 i[j]=i[j-1];
					 random--;
					 
					}
			}
		}
		return i;

	}
	
}
