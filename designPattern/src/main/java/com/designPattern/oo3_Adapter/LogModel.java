package com.designPattern.oo3_Adapter;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

/**
 * 日志数据对象
 * @author Gaoshudian
 */
@Data
@ToString
public class LogModel implements Serializable{

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

}
