package com.gao.base_001.base010_produceterCustomer2;

public class Customer implements Runnable{

	
	private Resource r;
	public Customer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}
