package com.gao.base_001.design014;

/**
 * future模式实例
 * @author gaoshudian
 * @date 2017年4月7日 上午10:54:41
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("做其他的事情...");
		
		String result = data.getRequest();
		System.out.println(result);
		
	}
}
