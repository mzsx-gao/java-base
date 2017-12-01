package com.gao.base_001.base001_thread;

public class Demo2 extends Thread{

	private String name;
	Demo2(String name){
		super(name);
	}
	public void run(){
		for(int x=0;x<100;x++){
			System.out.println(name+"...x="+x+"....name="+Thread.currentThread().getName());
		}
	}
}
