package com.gao.base_001.base009_produceterCustomer;

/*
 生产者，消费者。

 多生产者，多消费者的问题。
 if判断标记，只有一次，会导致不该运行的线程运行了。出现了数据错误的情况。
 while判断标记，解决了线程获取执行权后，是否要运行！

 notify:只能唤醒一个线程，如果本方唤醒了本方，没有意义。而且while判断标记+notify会导致死锁。
 notifyAll解决了本方线程一定会唤醒对方线程的问题。


 */
public class Resource {

	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name){
		while (flag)
			try {this.wait();} catch (InterruptedException e) {} // t1 t0
		this.name = name + count;// 烤鸭1 烤鸭2 烤鸭3
		count++;// 2 3 4
		System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);// 生产烤鸭1 ;生产烤鸭2 ; 生产烤鸭3
		flag = true;
		notifyAll();
	}
	public synchronized void out(){// t3
		while (!flag)
			try {this.wait();} catch (InterruptedException e) {} // t2 t3
		System.out.println(Thread.currentThread().getName() + "...消费者........" + this.name);// 消费烤鸭1
		flag = false;
		notifyAll();
	}
}
