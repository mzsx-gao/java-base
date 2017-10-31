package com.gao.base_001.conn008;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() throws InterruptedException {
		System.out.println("do some thing...");
		Thread.sleep(1000);
	}
}
