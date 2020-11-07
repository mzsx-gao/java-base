package go.multithread.base.oo2_middle.demo006_masterworker;

import java.util.Random;

/**
 * master-worker模式
 * 20个线程处理100个任务
 * @author gaoshudian
 * @date 2017年4月7日 上午11:03:28
 */
public class Main {

	public static void main(String[] args) {

		//20个worker(线程)
		Master master = new Master(new Worker(), 20);
		//100个task
		Random r = new Random();
		for (int i = 1; i <= 100; i++) {
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		master.execute();
		long start = System.currentTimeMillis();

		while (true) {
			if (master.isComplete()) {
				long end = System.currentTimeMillis() - start;
				int priceResult = master.getResult();
				System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
				break;
			}
		}

	}
}
