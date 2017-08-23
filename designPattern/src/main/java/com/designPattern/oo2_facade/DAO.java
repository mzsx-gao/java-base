package com.designPattern.oo2_facade;

public class DAO {

	public void generate(){
		ConfigModel cm=ConfigManager.getInstance().getConfigData();
		if(cm.isNeedGenDAO()){
			System.out.println("正在生成数据层代码文件");
		}
	}
}
