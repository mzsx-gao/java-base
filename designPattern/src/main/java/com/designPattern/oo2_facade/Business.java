package com.designPattern.oo2_facade;

public class Business {

	public void generate(){
		ConfigModel cm=ConfigManager.getInstance().getConfigData();
		if(cm.isNeedGenBusiness()){
			System.out.println("正在生成逻辑层代码文件");
		}
	}
}
