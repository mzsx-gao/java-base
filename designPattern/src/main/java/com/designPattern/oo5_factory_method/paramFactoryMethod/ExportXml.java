package com.designPattern.oo5_factory_method.paramFactoryMethod;

//导出成xml文件的对象
public class ExportXml implements ExportFileApi {

	public boolean export(String data) {
		// TODO Auto-generated method stub
		System.out.println("导出数据:'"+data+"'到xml文件");
		return true;
	}

}
