package com.designPattern.oo6_abstract_factory;

/**
 * Intel的CPU实现
 * @author GaoSD
 *
 */
public class IntelCPU implements CPUApi {

	//CPU的针脚数目
	private int pins=0;
	//构造方法
	public IntelCPU(int pins){
		this.pins=pins;
	}
	@Override
	public void calculate() {
		System.out.println("now in Intel CPU,pins="+pins);
	}

}
