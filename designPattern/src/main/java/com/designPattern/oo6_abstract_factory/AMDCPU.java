package com.designPattern.oo6_abstract_factory;

/**
 * AMD的CPU实现
 * @author GaoSD
 *
 */
public class AMDCPU implements CPUApi {

	//CPU的针脚数目
	private int pins=0;
	//构造方法
	public AMDCPU(int pins){
		this.pins=pins;
	}
	@Override
	public void calculate() {
		System.out.println("now in AMD CPU,pins="+pins);

	}

}
