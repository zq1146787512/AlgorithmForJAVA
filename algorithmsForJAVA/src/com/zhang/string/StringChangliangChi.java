package com.zhang.string;

public class StringChangliangChi {

	public static void main(String[] args) {
		boolean flag=true;
		String s = new String("1");
		String s1 = s.intern();
		String s2 = "1";
		System.out.println(s1 == s2);
		if (flag){ 
			String s3 = new String("1") + new String("1");// �ڳ�������û��"11"����
			s3.intern();// ��s3�Ķ������ü��볣�����С�
			String s4 = "11";// �ڳ������п����ҵ���11�������÷��ظ�s4��
			System.out.println(s3 == s4);
		}else {
			String s5 = new String("11");// �����������������ڳ�������Ѱ�ң�û�д�����11�������ڶ��ڴ��д�����11������
			s5.intern();// s5��ָ��Ķ����ָ�����ء�����s3ָ��Ļ��Ƕ��еĶ���
			String s6 = "11";// �ڳ������п����ҵ�����11����s4ָ�����ء�
			System.out.println(s5 == s6);
		}
	}

}
