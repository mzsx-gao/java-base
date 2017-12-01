package com.gao.oo1_base.base007_deadLock.simpleDemo;

public class Test implements Runnable {
	private boolean flag;

	Test(boolean flag) {
		this.flag = flag;
	}

	public void run() {

		if (flag) {
			while (true)
				synchronized (MyLock.locka) {
					System.out.println(Thread.currentThread().getName() + "..if   locka....");
					synchronized (MyLock.lockb) {

						System.out.println(Thread.currentThread().getName() + "..if   lockb....");
					}
				}
		} else {
			while (true)
				synchronized (MyLock.lockb) {
					System.out.println(Thread.currentThread().getName() + "..else  lockb....");
					synchronized (MyLock.locka) {
						System.out.println(Thread.currentThread().getName() + "..else   locka....");
					}
				}
		}

	}

}
