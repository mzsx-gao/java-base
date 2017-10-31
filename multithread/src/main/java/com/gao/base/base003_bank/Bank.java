package com.gao.base.base003_bank;

/**
 * 同步函数
 * @author Gao
 *
 */
public class Bank {
	private int sum;
	//private Object obj=new Object();
	public synchronized void add(int num){
		//synchronized (obj) {
			sum=sum+num;
			System.out.println("sum="+sum);
		//}
	}
}
