package com.designPattern.oo6_abstract_factory.old;

import com.designPattern.oo6_abstract_factory.CPUApi;
import com.designPattern.oo6_abstract_factory.MainboardApi;

/**
 * 装机工程师的类
 * @author GaoSD
 *
 */
public class old_ComputerEngineer {
	//定义组装机器需要的CPU
	private CPUApi cpu=null;
	//定义组装机器需要的主板
	private MainboardApi mainboard = null;
	//装机过程
	public void makeComputer(int cpuType,int mainboardType){
		//1.首先准备好装机所需要的配件
		prepareHardwares(cpuType,mainboardType);
		//2.组装机器
		//3.测试机器
		//4.交付客户
	}
	private void prepareHardwares(int cpuType, int mainboardType) {

		//直接找相应的工厂获取
		this.cpu=old_CPUFactory.createCPUApi(cpuType);
		this.mainboard=old_MainboardFactory.createMainboardApi(mainboardType);
		//测试一下配件是否好用
		this.cpu.calculate();
		this.mainboard.installCPU();
	}
}
