package com.designPattern.oo6_abstract_factory;

public class Schema1 implements AbstractFactory {

	@Override
	public CPUApi createCPUApi() {
		return new IntelCPU(1156);
	}

	@Override
	public MainboardApi createMainboardApi() {
		return new GAMainboard(1156);
	}

}
