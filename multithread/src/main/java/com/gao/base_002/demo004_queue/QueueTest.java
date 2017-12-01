package com.gao.base_002.demo004_queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 队列测试
 * 
 * @author gaoshudian
 * @date 2017年4月7日 上午10:12:18
 */
public class QueueTest {

	// 高性能无阻塞无界队列：ConcurrentLinkedQueue
	@Test
	public void concurrentLinkedQueueTest() {
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.add("e");
		System.out.println(q.poll()); // a 从头部取出元素，并从队列里删除
		System.out.println(q.size()); // 4
		System.out.println(q.peek()); // b 获取但不移除此队列的头
		System.out.println(q.size()); // 4
	}

	// 有界阻塞队列 ArrayBlockingQueue
	@Test
	public void arrayBlockingQueueTest() throws InterruptedException {
		final ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
		array.put("a");
		array.put("b");
		array.add("c");
		array.add("d");
		array.add("e");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					array.poll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();
		System.out.println("开始添加f...");
		array.put("f");
		System.out.println("添加f成功...");
		System.out.println(array.offer("a", 3, TimeUnit.SECONDS));
	}

	// 阻塞队列 LinkedBlockingQueue（队列容量可指定，可不指定。如果不指定则为‘Integer.MAX_VALUE’）
	@Test
	public void linkedBlockingQueue() {
		LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
		q.offer("a");
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.offer("e");
		q.add("f");
		System.out.println(q.size());

		for (Iterator<String> iterator = q.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
		List<String> list = new ArrayList<String>();
		System.out.println(q.drainTo(list, 3));
		System.out.println(list.size());
		for (String string : list) {
			System.out.println(string);
		}
	}

	// 阻塞队列SynchronousQueue 同步队列没有任何内部容量
	// 其中每个插入操作必须等待另一个线程的对应移除操作 ，反之亦然
	@Test
	public void synchronousQueueTest() {
		final SynchronousQueue<String> q = new SynchronousQueue<String>();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				q.add("asdasd");
			}
		});
		t2.start();
	}

	// 基于已链接节点的、任选范围的阻塞双端队列
	@Test
	public void linkedBlockingDequeTest() {
		LinkedBlockingDeque<String> dq = new LinkedBlockingDeque<String>(10);
		dq.addFirst("a");
		dq.addFirst("b");
		dq.addFirst("c");
		dq.addFirst("d");
		dq.addFirst("e");
		dq.addLast("f");
		dq.addLast("g");
		dq.addLast("h");
		dq.addLast("i");
		dq.addLast("j");
		// dq.offerFirst("k");
		System.out.println("查看头元素：" + dq.peekFirst());
		System.out.println("获取尾元素：" + dq.pollLast());
		Object[] objs = dq.toArray();
		for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
		}
	}

	// 无界阻塞队列PriorityBlockingQueue 可根据自定义的比较器对元素进行排序
	@Test
	public void priorityBlockingQueueTest() throws InterruptedException {
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("id为3");
		Task t2 = new Task();
		t2.setId(4);
		t2.setName("id为4");
		Task t3 = new Task();
		t3.setId(1);
		t3.setName("id为1");
		Task t4 = new Task();
		t4.setId(5);
		t4.setName("id为5");
		q.add(t1);
		q.add(t2);
		q.add(t3);
		q.add(t4);
		System.out.println("容器：" + q);
		System.out.println(q.take().getId());
		System.out.println("容器：" + q);
		System.out.println(q.take().getId());
		System.out.println(q.take().getId());
	}

}
