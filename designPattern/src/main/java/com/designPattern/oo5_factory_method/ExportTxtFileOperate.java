package com.designPattern.oo5_factory_method;

/**
 * 具体的创建器实现对象,实现创建导出成文本文件格式的对象
 * @author 高书电
 *
 * 2015年11月18日
 */
public class ExportTxtFileOperate extends ExportOperate {

	protected ExportFileApi factoryMethod() {
		// 创建导出成文本文件格式的对象
		return new ExportTxtFile();
	}

}
