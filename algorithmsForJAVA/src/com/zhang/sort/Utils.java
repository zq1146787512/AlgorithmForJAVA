package com.zhang.sort;

public class Utils {
	 static boolean less(Comparable<Integer> v, Comparable<Integer> w) {
		if((Integer)v<=(Integer)w){return true;}
		else return false;
	}

	static void exch(Comparable<Integer>[] a, int i, int j) {
		
		Comparable<Integer> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static boolean isSorted(Comparable<Integer>[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
	public static void show(Comparable<Integer>[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
