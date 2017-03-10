package com.zhang.sort;

/**
 * 希尔排序
 * @author admin
 *
 */
public class ShellSort {
	public static void sort(Comparable<Integer>[] a) {
		int N = a.length;
		int h = 1;
		while(h<N/3){h=3*h+1;}//先到最大的希尔值
		while (h >= 1) {
			for (int i = h; i <N; i++) {
				for (int j = i; j >=h && Utils.less(a[j], a[j-h]); j -= h) {//
					Utils.exch(a, j, j - h);
				}	
			}
			h = h /3;
		}
	}
	

	public static void main(String[] args) {
		Integer[] aa={1,5,2,4,6,7,3,43,5,2,5,6,345,543,2,34,4,32};
		sort(aa);
		assert Utils.isSorted(aa);
		Utils.show(aa);
	}

}
