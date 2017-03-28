package com.zhang.string;
import java.util.Scanner;
/**
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。
 * 小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
 * @author admin
 *输入数据包括n+1行：

第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小

接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色

输出小易会涂画的区域大小
 */
public class MaxSerialColor {
	
	public static int getMax(String[] k){
		int sumW=0;
		int sumB=0;
		for(int i=0;i<k.length;i++){
			int W=0;
			int B=0;
			for(int j=0;j<k.length;j++){
				if((k[j].charAt(i))=='W') {
					B=0;
					W+=1;
					sumW=sumW>=W?sumW:W;
					}else{
						W=0;
						B+=1;
						sumB=sumB>=B?sumB:B;
					}	
			}		
		}
		return sumB>=sumW?sumB:sumW;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		s.nextLine();
		String[] kk=new String[N];
		for(int i=0;i<N;i++){
			kk[i]=s.nextLine();
		}
		
		System.out.println(getMax(kk));
		
	}

}
