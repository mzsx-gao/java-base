package com.gao.base.base010_produceterCustomer2;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Customer con = new Customer(r);
		
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
