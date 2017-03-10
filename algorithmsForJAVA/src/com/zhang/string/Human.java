package com.zhang.string;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {

	public static int es() throws Exception {
		try {
			try {
				throw new Sneeze();
			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
				throw a;
			}
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
			return 1;
		} finally {
			System.out.println("Hello World!");//finally �ڷ���ֵ֮ǰ���У���֤����ı䷵��ֵ��
//			return 2;//error ��finally �в�����д����ֵ
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(es());;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}