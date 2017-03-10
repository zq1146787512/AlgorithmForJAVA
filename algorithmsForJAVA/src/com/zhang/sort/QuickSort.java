package com.zhang.sort;


public class QuickSort {
	
	public static void sort(Comparable<Integer>[] a){
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable<Integer>[] a,int lo,int hi) {
		if(hi<=lo) return ;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(Comparable<Integer>[] a,int lo,int hi){
		int i=lo;
		int j=hi+1;
		Comparable<Integer> v=a[lo];
		while(true){
			while(Utils.less(a[++i], v)){
				if(i==hi) break;
			}
			while(Utils.less(v, a[--j])){
				if(j==lo) break;
			}
			if(i>=j) break;
			Utils.exch(a, i, j);
		}
		Utils.exch(a, lo, j);
		return j;
	}
	public static void main(String[] args) {
		Integer[] a={1,2,534,234,134,5,23,21345,6,76,6,3453,345,345,54};
		sort(a);
		Utils.show(a);
		
		
	}

}
