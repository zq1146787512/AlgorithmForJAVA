package com.zhang.string;

public class StringKMP {
	
	public static int KMP(String pat,String text){//pat是模式字符串
		int N=pat.length();
		int M=text.length();
		int[] next=next(pat);
		int k=0;
		int j=0;
		while(k<M){
			if(pat.charAt(j)==text.charAt(k)) { j++; k++; } 						
			else {
				if(j==0) k++;
				else j=next[j]-1;
			}
			System.out.print((k-1)+" ");
			if(j==N) return j;	//匹配成功
		}
		return -1;//匹配失败			
	}
	//next数组，用来确定一个模式字符串的next数组KMP算法的关键。
	public static int[] next(String pat){
		int N=pat.length();
		int[] a=new int[N];
		a[0]=0;
		a[1]=1;
		for(int i=2;i<N;i++){
			a[i]=next(pat,i-1,i-1,a);
		}
		return a;
	}
	//递归找出next 数组的值，j是确定的值，i是变化的值，递归的关键
	public static int next(String pat,int j,int i,int[] a){
			while(j>0)
				if(pat.charAt(i)==pat.charAt(a[j]-1)){
				return a[j]+1;
				}
				else return next(pat, a[j]-1,i, a);
			return 1;
	}
	
	//test
	public static void main(String[] args) {
		String s="abcabcabdabba";
		String c="abcabd";
		int t=KMP(c,s);
		if(t==c.length()){
			System.out.println("匹配成功");
		}
		else System.out.println("匹配失败~！！！");
		
	}
}
