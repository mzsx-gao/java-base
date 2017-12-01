package com.gao.oo1_base.base004_synFunctionLock;

/**
 * 同步函数的使用的锁是this； 同步函数和同步代码块的区别： 同步函数的锁是固定的this 同步代码块的锁是任意的对象 建议使用同步代码块。
 * 
 * @author Gao
 */
public class Ticket implements Runnable {

	private int num = 1000;
	boolean flag = true;

	public void run() {
		if (flag){//同步代码块
			while (true) {
				synchronized (this) {
					if (num > 0) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
						}
						System.out.println(Thread.currentThread().getName() + ".....obj...." + num--);
					}
				}
			}
		}else{//同步函数
			while (true){
				this.show();
			}
		}
	}

	public synchronized void show() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + "...function..." + num--);
		}
	}
}
