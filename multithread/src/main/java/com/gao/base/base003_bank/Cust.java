package com.gao.base.base003_bank;

public class Cust implements Runnable{

	Bank bank=new Bank();
	public void run(){
		for(int x=0;x<3;x++){
			bank.add(100);
		}
	}
}
