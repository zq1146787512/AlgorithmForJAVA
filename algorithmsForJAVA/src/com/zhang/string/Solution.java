package com.zhang.string;
/**
 * สýื้
 * @author admin
 *
 */
public class Solution {
	public int[] multuply(int[] A){
		int length=A.length;
		int[] b=new int[length];
		int temp=1;
		
		for(int i=0;i<length;i++){
			int sum=1;
			for(int j=0;j<length;j++){
				temp=A[i];
				A[i]=1;
				sum=sum*A[j];
				A[i]=temp;
			}
			b[i]=sum;
		}
		return b;
	}
	public static void main(String[] args) {
		int[] a={9,2,3,4,5};
		int[] s=new Solution().multuply(a);
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}

}
