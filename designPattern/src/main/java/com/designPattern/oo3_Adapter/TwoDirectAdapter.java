package com.designPattern.oo3_Adapter;

import java.util.List;

/**
 * 双向适配器对象
 * @author Gaoshudian
 *
 */
public class TwoDirectAdapter implements LogDbOperateApi, LogFileOperateApi {

	/**
	 * 持有需要被适配的文件存储日志的接口对象
	 */
	private LogFileOperateApi fileLog;
	/**
	 * 持有需要被适配的Db存储日志的接口对象
	 */
	private LogDbOperateApi dbLog;
	
	/**
	 * 构造方法,传入需要被适配的对象
	 * @param fileLog
	 * @param dbLog
	 */
	public TwoDirectAdapter(LogFileOperateApi fileLog, LogDbOperateApi dbLog) {
		super();
		this.fileLog = fileLog;
		this.dbLog = dbLog;
	}

	/** 以下是把DB操作的方式适配成为文件实现方式的接口*/
	public List<LogModel> readLogFile() {
		return dbLog.getAllLog();
	}

	public void writeLogFile(List<LogModel> list) {
		for(LogModel lm : list){
			dbLog.createLog(lm);
		}

	}

	/** 以下是把文件操作的方式适配成为DB实现方式的接口  */
	public void createLog(LogModel lm) {
		//先读取文件的内容
		List<LogModel> list = fileLog.readLogFile();
		//加入新的日志对象
		list.add(lm);
		//重新写入文件
		fileLog.writeLogFile(list);

	}

	public void updateLog(LogModel lm) {

		//先读取文件的内容
		List<LogModel> list = fileLog.readLogFile();
		//修改相应的日志对象
		for(int i=0;i<list.size();i++){
			if(list.get(i).getLogId().equals(lm)){
				list.set(i, lm);
				break;
			}
		}
		//重新写入文件
		fileLog.writeLogFile(list);
				
	}

	public void removeLog(LogModel lm) {
		//先读取文件的内容
		List<LogModel> list = fileLog.readLogFile();
		//删除相应的日志对象
		list.remove(lm);
		//重新写入文件
		fileLog.writeLogFile(list);

	}

	public List<LogModel> getAllLog() {
		return fileLog.readLogFile();
	}


}
