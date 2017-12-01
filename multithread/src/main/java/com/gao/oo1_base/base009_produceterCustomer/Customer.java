package com.gao.oo1_base.base009_produceterCustomer;

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
