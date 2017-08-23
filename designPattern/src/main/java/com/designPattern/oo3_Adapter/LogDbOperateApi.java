package com.designPattern.oo3_Adapter;

import java.util.List;

/**
 * 定义操作日志的应用接口
 * @author Gaoshudian
 *
 */
public interface LogDbOperateApi {

	/**
	 * 新增日志
	 * @param lm
	 */
	public void createLog(LogModel lm);
	/**
	 * 修改日志
	 * @param lm
	 */
	public void updateLog(LogModel lm);
	/**
	 * 删除日志
	 * @param lm
	 */
	public void removeLog(LogModel lm);
	/**
	 * 获取所有的日志
	 * @return
	 */
	public List<LogModel> getAllLog();
}
