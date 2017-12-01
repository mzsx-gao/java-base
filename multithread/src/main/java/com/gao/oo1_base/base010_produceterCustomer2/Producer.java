package com.gao.oo1_base.base010_produceterCustomer2;

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
