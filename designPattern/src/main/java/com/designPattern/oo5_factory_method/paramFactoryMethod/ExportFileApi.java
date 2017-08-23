package com.designPattern.oo5_factory_method.paramFactoryMethod;

/**
 * 导出的文件对象的接口
 * @author Administrator
 *
 */
public interface ExportFileApi {

	/**
	 * 导出内容成为文件
	 * @param data
	 * @return
	 */
	public boolean export(String data);
	
}
