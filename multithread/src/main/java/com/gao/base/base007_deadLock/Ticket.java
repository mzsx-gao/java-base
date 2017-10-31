package com.gao.base.base007_deadLock;

public class Ticket implements Runnable {

	private int num = 100;
	Object obj = new Object();
	boolean flag = true;

	public void run() {
		if (flag)
			while (true) {
				synchronized (obj) {
					show();
				}
			}
		else
			while (true)
				this.show();
	}

	public synchronized void show() {

		synchronized (obj) {
			if (num > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}

				System.out.println(Thread.currentThread().getName() + ".....sale...." + num--);
			}
		}
	}

}
