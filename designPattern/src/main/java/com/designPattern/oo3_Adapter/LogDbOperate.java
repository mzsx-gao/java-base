package com.designPattern.oo3_Adapter;

import java.util.List;

public class LogDbOperate implements LogDbOperateApi {

	public void createLog(LogModel lm) {

		System.out.println("新增日志...lm="+lm);
	}

	public void updateLog(LogModel lm) {

		System.out.println("更新日志...."+lm);
	}

	public void removeLog(LogModel lm) {

		System.out.println("删除日志..."+lm);
	}

	public List<LogModel> getAllLog() {
		System.out.println("查询日志...");
		return null;
	}

}
