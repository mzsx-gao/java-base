package com.gao.base.base001_thread;

public class Demo3 implements Runnable {

	public void run() {

		show();
	}
	public void show(){
		for(int x=0;x<20;x++){
			System.out.println(Thread.currentThread().getName()+"..."+x);
		}
	}

}
