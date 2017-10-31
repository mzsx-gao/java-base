package com.gao.base_001.conn008;

import java.util.concurrent.CountDownLatch;

public class Driver { 
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(3);

		for (int i = 0; i < 3; ++i){
			new Thread(new Worker(startSignal, doneSignal)).start();
		}

		System.out.println("...");
		Thread.sleep(1000);
		startSignal.countDown(); // let all threads proceed
		Thread.sleep(1000);
		System.out.println("...");
		doneSignal.await(); // wait for all to finish
	}
}
