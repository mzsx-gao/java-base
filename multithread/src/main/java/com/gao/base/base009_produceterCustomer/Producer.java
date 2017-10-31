package com.gao.base.base009_produceterCustomer;

public class Producer implements Runnable{

	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("烤鸭");
		}
	}
}
