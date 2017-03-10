package com.zhang.string;

public class ViolenceStringMethod {
	// 暴力字符串的解法1：
	public static int search1(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == M)
				return i;
		}
		return N;
	}

	// 暴力字符串的解法2：
	public static int search2(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (txt.charAt(i) == pat.charAt(j))
				j++;
			else {
				i = i - j;
				j = 0;
			}
		}
		if (j == M)
			return i - M;
		else
			return N;
	}
	//测试
	public static void main(String[] args) {
		int a = search1(
				"dsad",
				"fdsfgerxeerrtgjkweaioewjkddujdsadresgrejfdjgiooejjdfjhdskdsaddfgfgerjfdfhnsjdfsdssafsdsafassdasdsdfasdas");
		int b = search2(
				"dsad",
				"fdsfgerxeerrtgjkweaioewjkddujdsadresgrejfdjgiooejjdfjhdskdsaddfgfgerjfdfhnsjdfsdssafsdsafassdasdsdfasdas");

		System.out.println(a + "...." + b);
	}

}
