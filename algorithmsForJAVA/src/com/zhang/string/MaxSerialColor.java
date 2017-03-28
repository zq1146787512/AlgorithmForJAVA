package com.zhang.string;
import java.util.Scanner;
/**
 * С����һ��n*n�����̣����̵�ÿһ�����Ӷ�Ϊ��ɫ���߰�ɫ��С������Ҫ����ϲ���ĺ�ɫȥͿ�����̡�
 * С�׻��ҳ�������ĳһ����ӵ����ͬ��ɫ����������ȥͿ��������С����������Ϳ�����ٸ����
 * @author admin
 *�������ݰ���n+1�У�

��һ��Ϊһ������n(1 �� n �� 50),�����̵Ĵ�С

��������n��ÿ��һ���ַ�����ʾ��i�����̵���ɫ��'W'��ʾ��ɫ��'B'��ʾ��ɫ

���С�׻�Ϳ���������С
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
