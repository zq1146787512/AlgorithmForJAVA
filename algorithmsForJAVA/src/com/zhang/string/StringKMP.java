package com.zhang.string;

public class StringKMP {
	
	public static int KMP(String pat,String text){//pat��ģʽ�ַ���
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
			if(j==N) return j;	//ƥ��ɹ�
		}
		return -1;//ƥ��ʧ��			
	}
	//next���飬����ȷ��һ��ģʽ�ַ�����next����KMP�㷨�Ĺؼ���
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
	//�ݹ��ҳ�next �����ֵ��j��ȷ����ֵ��i�Ǳ仯��ֵ���ݹ�Ĺؼ�
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
			System.out.println("ƥ��ɹ�");
		}
		else System.out.println("ƥ��ʧ��~������");
		
	}
}
