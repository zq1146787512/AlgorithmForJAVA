package com.zhang.string;

public class JavaVMStackSOF {
	/*����ջ��������ƣ����Խ��Ϊ11425���ң�����Լ���ֵ��ʱ��ᱨջ����Ĵ���
	private int stackLength=1;
	public void stackLeak(){
		if(stackLength<11500){
			stackLength++;
			stackLeak();
		}
		
	}
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("StackLength : "+oom.stackLength);
			throw e;
		}
	}
	*/
	
	private void dontStop(){
		while(true){}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
				dontStop();
					
				}
			});
			thread.start();
		}
	}
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		oom.stackLeakByThread();
	}
	

}
