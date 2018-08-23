package com.gao.oo1_base.base010_produceterCustomer2;

public class Customer implements Runnable{

	private Resource r;
	public Customer(Resource r) {
		this.r = r;
	}
	public void run(){
		while(true) {
		    try{
                r.out();
            }catch (Exception e){
		        e.printStackTrace();
            }
		}
	}
}
