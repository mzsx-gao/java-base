package com.gao.oo3_height.demo001_Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UseExecutors {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程
		/*public static ExecutorService newSingleThreadExecutor() {
		        return new FinalizableDelegatedExecutorService
		            (new ThreadPoolExecutor(1, 1,
		                                    0L, TimeUnit.MILLISECONDS,
		                                    new LinkedBlockingQueue<Runnable>()));
		 }*/
		Executors.newSingleThreadExecutor();
		
		//创建一个可根据需要创建新线程的线程池
		/*public static ExecutorService newCachedThreadPool() {
	        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
	                                      60L, TimeUnit.SECONDS,
	                                      new SynchronousQueue<Runnable>());
	    }*/
		Executors.newCachedThreadPool();
		
		//创建一个可重用固定线程数的线程池
		/* public static ExecutorService newFixedThreadPool(int nThreads) {
		        return new ThreadPoolExecutor(nThreads, nThreads,
		                                      0L, TimeUnit.MILLISECONDS,
		                                      new LinkedBlockingQueue<Runnable>());
		}*/
		Executors.newFixedThreadPool(10);
		
		//创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Temp command = new Temp();
        scheduler.scheduleWithFixedDelay(command, 1, 1, TimeUnit.SECONDS);
		
	}
}
