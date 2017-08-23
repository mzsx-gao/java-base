package com.designPattern.oo3_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试双向适配器
 * @author Gaoshudian
 *
 */
public class TwoDirectAdapterClient {

	public static void main(String[] args) {
		//准备日志内容,也就是测试的数据
		LogModel lml=new LogModel();
		lml.setLogId("001");
		lml.setOperateUser("gaoshudian");
		lml.setOperateTime("2015-10-21 10:08:18");
		lml.setLogContent("这是一个测试");
		
		List<LogModel> list=new ArrayList<>();
		list.add(lml);
		
		//创建操作日志文件的对象
		LogFileOperateApi fileLogApi=new LogFileOperate("");
		LogDbOperateApi ddbLogApi=new LogDbOperate();
		
		//创建经过双向适配后的操作日志的接口对象
		LogFileOperateApi fileLogApi2=new TwoDirectAdapter(fileLogApi, ddbLogApi);
		LogDbOperateApi dbLogApi2=new TwoDirectAdapter(fileLogApi, ddbLogApi);
		
		//先测试从文件操作适配到第二版
		//虽然调用的是第二版的接口,其实是文件操作在实现
		dbLogApi2.createLog(lml);
		List<LogModel> allLog = dbLogApi2.getAllLog();
		System.out.println("allLog="+allLog);
		//在测试从数据库存储适配成第一版的接口
		//也就是调用第一版的接口,其实是数据实现
		fileLogApi2.writeLogFile(list);
		fileLogApi2.readLogFile();
	}
}
