package com.gao.base_001.base008_resourceDemo;

public class Resource {

	String name;
	String sex;
	boolean flag = false;//true:消费，false:生产
	public synchronized void set(String name, String sex) {
		if (flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}
	public synchronized void out() {
		if (!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println(name + "...+...." + sex);
		flag = false;
		this.notify();
	}
}
