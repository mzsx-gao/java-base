package com.designPattern.oo6_abstract_factory;

/**
 * 抽象工厂的接口,声明创建抽象产品对象的操作
 * @author GaoSD
 *
 */
public interface AbstractFactory {

	//创建CPU的对象
	public CPUApi createCPUApi();
	//创建主板的对象
	public MainboardApi createMainboardApi();
}
