package com.designPattern.oo5_factory_method.paramFactoryMethod;

/**
 * 扩展工厂方法
 * @author gao
 *
 */
public class ExportOperate2 extends ExportOperate {

	protected ExportFileApi factoryMethod(int type){
		ExportFileApi api=null;
		if(type == 3){
			api=new ExportXml();
		}else{
			//其他的还是让父类来实现
			api=super.factoryMethod(type);
		}
		return api;
	}
}
