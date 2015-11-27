package com.chap01;

public class LogOfN {

	public static void main(String[] args) {
		System.out.println(getBase2Log(64));
	}
	
	public static int getBase2Log(int n){
		int lg=0;
		int temp=2;
		while(true){
			if (temp > n){
				break;
			}else{
				temp=temp*2;
				lg++;
			}
		}
		return lg;
	}
}
