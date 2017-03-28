package com.zhang.string;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LCS {
	//获取辅助数组
	public static int[][] getLCS(String a,String b){
		char[] s1 = a.toCharArray();
		char[] s2 = b.toCharArray();
		int[][] c = new int[s1.length+1][s2.length+1];//构造一个二维的数组，这里数组的大小加1，是为了下面计算数组的值做准备的
		//将横向和纵向的边界值设为0
		for(int i=0;i<=s1.length;i++){
			c[i][0] = 0;
		}
		
		for(int i=1;i<=s2.length;i++){
			c[0][i] = 0;
		}
		//动态规划的核心，多个子问题中找到最大的一个
		for(int i=0;i<s1.length;i++){
			for(int j=0;j<s2.length;j++){
				if(s1[i]==s2[j]){
					c[i+1][j+1]=c[i][j]+1;
				}else{
					c[i+1][j+1]=(c[i+1][j]>=c[i][j+1]?c[i+1][j]:c[i][j+1]);
				}
			}
		}	
		return c;
	}
	//求获得的最大子序列
	public static String getLCS(int[][] c,String a,int x,int y){
		char[] s1 = a.toCharArray();
		StringBuilder s = new StringBuilder();	
		
		if(x==0||y==0) return s.toString();
		
		if(c[x][y]==c[x-1][y-1]+1) {
			s.append(getLCS(c, a, x-1, y-1));
			s.append(s1[x-1]);
		}else if(c[x][y]==c[x-1][y]){
			s.append(getLCS(c, a, x-1, y));
		}else s.append(getLCS(c, a, x, y-1));
		return s.toString();
	}
	//测试
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("输入为： ");
		String input = s.nextLine();
		String[] inputs = input.split(" ");
		String a=inputs[0];
		String b=inputs[1];
		
		int[][] c= getLCS(a, b);
		String k=getLCS(c, a, a.length(), b.length());
		System.out.println("输出为： "+k);	
		
		
	}
	
	
	
	
	

}
