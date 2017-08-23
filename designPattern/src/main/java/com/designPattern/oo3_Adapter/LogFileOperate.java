package com.designPattern.oo3_Adapter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 将日志记录到文件中
 * @author Gaoshudian
 *
 */
public class LogFileOperate implements LogFileOperateApi {

	/**
	 * 日志文件的路径和文件名称,默认是当前项目根下的AdapterLog.log
	 */
	private String logFilePathName="AdapterLog.log";
	
	/**
	 * 构造方法
	 * @param logFilePathName
	 */
	public LogFileOperate(String logFilePathName){
		if(logFilePathName !=null && logFilePathName.trim().length()>0){
			this.logFilePathName=logFilePathName;
		}
	}
	@SuppressWarnings("unchecked")
	public List<LogModel> readLogFile() {
		List<LogModel> list=null;
		ObjectInputStream oin=null;
		try {
			File f=new File(logFilePathName);
			if(f.exists()){
				oin=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				list=(List<LogModel>) oin.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(oin!=null){
					oin.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	public void writeLogFile(List<LogModel> list) {

		File f=new File(logFilePathName);
		ObjectOutputStream oout=null;
		try{
			oout=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oout.writeObject(list);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				oout.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
