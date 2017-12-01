package com.gao.oo1_base.base001_thread;

/**
 * java的垃圾回收机制就是多线程的
 * @author Gao
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		new Demo();
		new Demo();
		new Demo();
		System.gc();
		System.out.println("Hello World!");
	}
}
