package com.zhang.string;
/**
 * 字符串的一些特殊情况
 * @author admin
 *
 */
public class StringTest {
	public static void main(String[] args) {
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";
		String s6 = s3 + s4;
		System.out.println(s1 == s2);
		System.out.println("  s1hashcode:" + s1.hashCode() + "   s2hashcode:"
				+ s2.hashCode() + "  S6hashcode:" + s6.hashCode());
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		System.out.println(s1 == s6.intern());
		System.out.println(s2 == s2.intern());

	}

}
