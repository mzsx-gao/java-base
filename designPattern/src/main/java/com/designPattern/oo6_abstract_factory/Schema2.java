package com.designPattern.oo6_abstract_factory;

public class Schema2 implements AbstractFactory {

	@Override
	public CPUApi createCPUApi() {
		return new IntelCPU(939);
	}

	@Override
	public MainboardApi createMainboardApi() {
		return new GAMainboard(939);
	}

}
