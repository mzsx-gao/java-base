package com.designPattern.oo5_factory_method.IOC_DI;

public class A {

	/**
	 * 等待被注入进来
	 */
	private C c=null;
	/**
	 * 注入资源c的方法
	 * @param c 被注入的资源
	 */
	public void setC(C c){
		this.c=c;
	}
	
	public void t1(){
		/**
		 * 这里需要使用c,可是又不让主动去创建c了,怎么办?
		 * 反正就要求从外部注入,这样更省心
		 * 自己不用管怎么获取c,直接使用就好了
		 */
		c.tc();
	}
	
}
