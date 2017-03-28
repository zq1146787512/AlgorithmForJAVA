package com.zhang.string;

public class StringChangliangChi {

	public static void main(String[] args) {
		boolean flag=true;
		String s = new String("1");
		String s1 = s.intern();
		String s2 = "1";
		System.out.println(s1 == s2);
		if (flag){ 
			String s3 = new String("1") + new String("1");// 在常量池中没有"11"对象
			s3.intern();// 将s3的对象引用加入常量池中、
			String s4 = "11";// 在常量池中可以找到‘11‘的引用返回给s4。
			System.out.println(s3 == s4);
		}else {
			String s5 = new String("11");// 创建两个对象首先在常量池中寻找，没有创建’11‘，再在堆内存中创建’11‘对象
			s5.intern();// s5的指向的对象的指向常量池。但是s3指向的还是堆中的对象。
			String s6 = "11";// 在常量池中可以找到对象‘11‘，s4指向常量池。
			System.out.println(s5 == s6);
		}
	}

}
