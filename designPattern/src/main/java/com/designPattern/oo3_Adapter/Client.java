package com.designPattern.oo3_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试把文件操作的方式适配成为DB实现方式的接口
 *
 * @author Gaoshudian
 */
public class Client {

    public static void main(String[] args) {
        //准备日志内容,也就是测试的数据
        LogModel lml = new LogModel();
        lml.setLogId("001");
        lml.setOperateUser("gaoshudian");
        lml.setOperateTime("2015-10-21 10:08:18");
        lml.setLogContent("这是一个测试");

        List<LogModel> list = new ArrayList<>();
        list.add(lml);

        //创建操作日志文件的对象
        LogFileOperateApi logFileApi = new LogFileOperate("");
        //创建新版操作日志的接口对象
        LogDbOperateApi api = new Adapter(logFileApi);
        //保存日志文件
        api.createLog(lml);
        //读取日志文件的内容
        List<LogModel> readLog = api.getAllLog();
        System.out.println("readLong=" + readLog);
    }
}
