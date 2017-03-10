package com.zhang.sort;

public class KuaiPpai {
	
	

	public static void sort(Comparable<Integer>[] a) {
		int lo = 0;
		int len = a.length;
		sort(a, lo, len - 1);
	}

	public static void sort(Comparable<Integer>[] a, int lo, int len) {
		if (lo >= len)
			return;
		else {
			int mid = partition(a, lo, len);
			sort(a, lo, mid - 1);
			sort(a, mid + 1, len);
		}
	}

	public static int partition(Comparable<Integer>[] a, int lo, int len) {
		Comparable<Integer> v = a[lo];
		int i = lo, j = len + 1;// len�Ǵ�sort(Comparable<Integer>[]
								// a)�д��ݹ������ı����ͼ���1�����Ҫ�ӻ�������Ϊ�������whileѭ������--j;
		while (true) {
			while (Utils.less(a[++i], v)) {
				if (i == len)
					break;
			}
			while (Utils.less(v, a[--j])) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			Utils.exch(a, i, j);
		}
		Utils.exch(a, lo, j);
		return j;
	}

	public static void main(String[] args) {
		double d=-1.5;
		System.out.println(Math.ceil(d)+"  "+Math.floor(d));

	}

}
