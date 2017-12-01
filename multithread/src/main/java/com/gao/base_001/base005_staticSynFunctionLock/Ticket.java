package com.gao.base_001.base005_staticSynFunctionLock;

/**
 * 静态的同步函数使用的锁是 该函数所属字节码文件对象 可以用 getClass方法获取，也可以用当前 类名.class 表示
 * 
 * @author Gao
 * 
 */
public class Ticket implements Runnable {

	private static int num = 100;
	boolean flag = true;

	@SuppressWarnings("static-access")
	public void run() {
		if (flag)
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
		else
			while (true)
				this.show();
	}

	public static synchronized void show() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + "...function..." + num--);
		}
	}
}
