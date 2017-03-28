package com.zhang.string;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LCS {
	//��ȡ��������
	public static int[][] getLCS(String a,String b){
		char[] s1 = a.toCharArray();
		char[] s2 = b.toCharArray();
		int[][] c = new int[s1.length+1][s2.length+1];//����һ����ά�����飬��������Ĵ�С��1����Ϊ��������������ֵ��׼����
		//�����������ı߽�ֵ��Ϊ0
		for(int i=0;i<=s1.length;i++){
			c[i][0] = 0;
		}
		
		for(int i=1;i<=s2.length;i++){
			c[0][i] = 0;
		}
		//��̬�滮�ĺ��ģ�������������ҵ�����һ��
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
	//���õ����������
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
	//����
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("����Ϊ�� ");
		String input = s.nextLine();
		String[] inputs = input.split(" ");
		String a=inputs[0];
		String b=inputs[1];
		
		int[][] c= getLCS(a, b);
		String k=getLCS(c, a, a.length(), b.length());
		System.out.println("���Ϊ�� "+k);	
		
		
	}
	
	
	
	
	

}
