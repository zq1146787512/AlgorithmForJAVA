package com.zhang.sort;

import java.util.Scanner;

public class HuiWen {

	public static int max(int a, int b) {
		return a >=b ? a : b;
	}

	public static int maxSubString(String s) {
		int[][] max = new int[s.length()+1][s.length()+1];
		
		for (int i = 1; i <=s.length(); i++) {
			max[i][0] = 0;
			max[0][i] = 0;
		}
		max[0][0]=0;
		for (int i = 1; i <=s.length(); i++) {
//			System.out.println(s.charAt(i));
			if (s.charAt(i - 1) == s.charAt(s.length() - i)) {
				max[i][s.length() - i] = max[i - 1][s.length() - i] + 1;
			} else {
				max[i][s.length() - i] = max(
						max[i - 1][s.length() - i +1], max[i][s.length() -i]);
			}

		}
		return max[s.length()][s.length()];

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String k = s.next();
		System.out.println(maxSubString(k));

	}

}
