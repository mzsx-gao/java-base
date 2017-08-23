package com.designPattern.oo6_abstract_factory;

/**
 * 技嘉的主板
 * @author GaoSD
 *
 */
public class GAMainboard implements MainboardApi {

	//CPU插槽的孔数
	private int cpuHoles=0;
	//构造方法,传入CPU插槽的孔数
	public GAMainboard(int cpuHoles){
		this.cpuHoles=cpuHoles;
	}
	@Override
	public void installCPU() {

		System.out.println("now in GAMainboard,cpuHoles="+cpuHoles);
	}

}
