package com.zhang.string;

public class testSHUZU {
	public boolean Find(int target, int[][] array) {
		int a = array[0].length;// 列数
		int b = array.length;// 行数
		int k = a <= b ? a : b;
		System.out.println(a + "  " + b);
		int a1 = 0, a2 = 0, a3 = 0;
		
		for (int i = 0; i < k; i++) {
			if (array[i][i] ==target) {
				return true;
			}
			if (array[i][i] > target) {
				a1 = i;break;
			}
			
			
		}
		System.out.println(a+" "+b);
//		System.out.println(a1);
		//行数
		for (int i = a1; i < b; i++) {
			if(array[i][0] == target)
				{return true;}
			if (array[i][0] > target) {
				a2 = i;break;
			}else{a2=b-1;}
			
		}
//		System.out.println(a2);
//
		for (int i = a1; i < a; i++) {
			if(array[0][i] == target)
				{return true;}
			if (array[0][i] > target) {
				a3 = i;break;
			}else{a3=a-1;}
//			System.out.println("25");
		}
		for (int i = a1; i <=a2; i++) {
			for (int j = 1; j <a1; j++) {
//				System.out.println(a2+"  "+a1);
//				System.out.println(array[i][j]);
				if (array[i][j] ==target) {
					return true;
				}
			}
		}
		
		for (int i = a1; i < a3; i++) {
			for (int j = 1; j < a1; j++) {
				System.out.println(array[j][i]);
				if (array[j][i] == target) {
					return true;
				}
			}
		}
		
		

		return false;
	}

	public static void main(String[] args) {
		int[][] a = { {} };
		boolean s = new testSHUZU().Find(7, a);
		System.out.println(s);

	}

}
