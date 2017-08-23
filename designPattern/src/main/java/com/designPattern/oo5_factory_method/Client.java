package com.designPattern.oo5_factory_method;

public class Client {

	public static void main(String[] args) {
		//创建需要使用的Creator对象
		ExportOperate operate=new ExportTxtFileOperate();
		//调用输出数据的功能方法
		operate.export("测试数据");
	}
}
