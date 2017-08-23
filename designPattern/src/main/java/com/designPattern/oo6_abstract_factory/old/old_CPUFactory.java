package com.designPattern.oo6_abstract_factory.old;

import com.designPattern.oo6_abstract_factory.AMDCPU;
import com.designPattern.oo6_abstract_factory.CPUApi;
import com.designPattern.oo6_abstract_factory.IntelCPU;

/**
 * 创建CPU的简单工厂
 * @author GaoSD
 *
 */
public class old_CPUFactory {

	public static CPUApi createCPUApi(int type){
		CPUApi cpu=null;
		//根据参数来选择并创建相应的CPU对象
		if(type==1){
			cpu=new IntelCPU(1156);
		}else if(type==2){
			cpu=new AMDCPU(939);
		}
		return cpu;
	}
}
