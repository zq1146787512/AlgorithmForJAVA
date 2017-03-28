package com.zhang.string;


public class OOMObject {
	public static OOMObject save = null;
	
	 public  void isAlive(){
		System.out.print("yes,i am alive!");
	}
	
	@Override
	protected void finalize(){
		try {
			super.finalize();
			System.out.println("finalize method executed!");
			OOMObject.save = this;
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Throwable {
		save = new OOMObject();
		
		save = null;
		System.gc();
		Thread.sleep(500);
		if(save!=null){
			save.isAlive();
		}else {
			System.out.println("no ,i am dead");
		}
		
		save = null;
		System.gc();
		Thread.sleep(500);
		if(save!=null){
			save.isAlive();
		}else {
			System.out.println("no ,i am dead");
		}
	}

}
