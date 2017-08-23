package com.designPattern.oo3_Adapter;

import java.io.Serializable;

/**
 * 日志数据对象
 * @author Gaoshudian
 *
 */
public class LogModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志编号
	 */
	private String logId;
	/**
	 * 操作人
	 */
	private String operateUser;
	/**
	 * 操作时间
	 */
	private String operateTime;
	/**
	 * 日志内容
	 */
	private String logContent;
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	@Override
	public String toString() {
		return "LogModel [logId=" + logId + ", operateUser=" + operateUser
				+ ", operateTime=" + operateTime + ", logContent=" + logContent
				+ "]";
	}
	
}
