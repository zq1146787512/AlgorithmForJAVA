package com.zhang.string;

public class JavaVMStackSOF {
	/*测试栈的深度限制，测试结果为11425左右，当大约这个值的时候会报栈溢出的错误
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
