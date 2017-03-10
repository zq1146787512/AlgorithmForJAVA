package com.zhang.string;

import java.util.Arrays;

public class KMP {
	private String pat;
	private int[][] dfa;

	public KMP(String pat){
//		int[] a={1,2,3,4,5,23,32};//如何得到子数组
//		int[] b=Arrays.copyOfRange(a, 1, 3);
//		for(int i=0;i<b.length;i++){
//		System.out.println(b[i]);}
		this.pat=pat;
		int M=pat.length();
		int R=256;
		dfa=new int[R][M];
		dfa[pat.charAt(0)][0]=0;
		for(int X=0,j=1;j<M;j++){
			for(int c=0;c<R;c++){
				dfa[c][j]=dfa[c][X];
				System.out.println("dfa["+c+"]["+j+"]=="+dfa[c][j]);
			}
			dfa[pat.charAt(j)][j]=j+1;
			X=dfa[pat.charAt(j)][X];
		}
		
		
	}
	public  int search(String txt){
		int i,j;
		int N=txt.length();
		int M=pat.length();		
		for(i=0,j=0;i<N&&j<M;i++){
			j=dfa[txt.charAt(i)][j];
//			System.out.println(txt.charAt(i));
		}
		if(j==M) return i-M;
		else return N;
	}
	
	
	
	public static void main(String[] args) {
		KMP kmp=new KMP("asdf");
		int k=kmp.search("fgdjsdasdfifdjjksdklsdaklds");
		for(int i=0;i<k;i++){
			System.out.println(i);
		}
//		System.out.println(a);
		
	}

}
