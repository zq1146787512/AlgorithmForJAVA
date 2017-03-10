package com.zhang.string;

import java.util.Scanner;

public class Testss {
	
	public  int method(int[] a,int n,int t,int c ){
		int count=0;	
		for(int i=0;i<n-c;i++){
			int sum=0;
			for(int j=i;j<c+i;j++){
				sum=sum+a[j];
				}
			if(sum<t){
				count++;
			}
		}
		return count;
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int t=s.nextInt();
		int c=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		
		System.out.println(new Testss().method(a,n,t,c));;
	}
	
	
	

}
