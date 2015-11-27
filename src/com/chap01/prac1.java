package com.chap01;

import com.util.StdDraw;
import com.util.StdOut;

public class prac1 {
	public static void main(String[] args) {
		System.out.println(getAbsVal(-3));
		System.out.println(getAbsVal(4));
		System.out.println(getDoubleAbsVal(-0.04));
		System.out.println(getDoubleAbsVal(3.04));
		
		System.out.println(1 + 2 + 3 + 4.0);
		System.out.println(4.1 > 4);
		System.out.println(1+2+"3");
		int a=2,b=3,c=0;
		if (a > b) c = 0; else b = 0;
		
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++)
		{
		StdOut.println(f);
		f = f + g;
		g = f - g;
		}
		
		
		double t = 25.0;
		while (Math.abs(t - 25.0/t) > .001)
		t = (25.0/t + t) / 2.0;
		StdOut.printf("%.5f\n", t);
		
		int sum = 0;
		for (int i = 1; i < 1000; i++)
		for (int j = 0; j < i; j++)
		sum++;
		StdOut.println(sum);
		
		sum = 0;
		for (int i = 1; i < 1000; i *= 2)
		for (int j = 0; j < 10; j++)
		sum++;
		StdOut.println(sum);
		
		System.out.println('b');
		
		System.out.println('b'+'c');
		
		System.out.println((char) ('a' + 4));
		
		System.out.println("convert int to binary "+ convertIntToBinaryString(10));
		
//		StdDraw.setPenColor(StdDraw.BLACK);
//		StdDraw.point(1.0, 3.0);
//		StdDraw.line(1.0, 3.0, 4.0, 6.0);
		
	}
	
	public static int getAbsVal(int x){
		if(x<0) return -x;
		return x;
	}
	
	public static double getDoubleAbsVal(double x){
		if(x<0) return -x;
		return x;
	}
	
	public static String convertIntToBinaryString(int a){
		String s="";
		for (int i = a; i>0 ; i=i/2) {
			s=(i%2)+s;
		}
		return s;
	}
	
	
}
