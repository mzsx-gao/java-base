package gao.dbpools.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import com.mysql.jdbc.Driver;

public class MyPoolImpl implements IMyPool {

    private static String driver = null;

    private static String url = null;

    private static String user = null;

    private static String password = null;

    // 限制连接池中的连接数量参数
    private static int initCount = 3;

    private static int stepSize = 10;

    private static int poolMaxSize = 150;

    //private static Vector<PooledConnection> pooledConnections = new Vector<PooledConnection>();
    private static CopyOnWriteArrayList<PooledConnection> pooledConnections = new CopyOnWriteArrayList<>();


    //构造方法就是初始化参数
    public MyPoolImpl() {
        //分层设计
        init();
    }

    //初始化参数在外面的Config 流
    private void init() {
        System.out.println("初始化连接池...");
        //外部配置具体参数的读取  所有的外部配置读取 流
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("jdbcPool.properties");
        Properties properties = new Properties();
        try {
            properties.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("jdbcDriver");
        url = properties.getProperty("jdbcurl");
        user = properties.getProperty("userName");
        password = properties.getProperty("password");
        // 限制连接数量参数初始化 习惯优于默认配置的思想
        if (Integer.valueOf(properties.getProperty("initCount")) > 0) {
            initCount = Integer.valueOf(properties.getProperty("initCount"));
        }
        if (Integer.valueOf(properties.getProperty("stepSize")) > 0) {
            stepSize = Integer.valueOf(properties.getProperty("stepSize"));
        }
        if (Integer.valueOf(properties.getProperty("poolMaxSize")) > 0) {
            poolMaxSize = Integer.valueOf(properties.getProperty("poolMaxSize"));
        }
        try {
            Class.forName(driver);
            //创建连接对象 管理起来 设计创建行为合法性判断
//            DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建连接数量交给 我们连接池架构  通过什么条件才能创建连接
        // 初始化连接池中的连接数量
        createConnections(initCount);

    }

    //高竞争状态的业务场景
    @Override
    public PooledConnection getConnection() {
        System.out.println("目前连接池的数量为..."+pooledConnections.size());
        if (pooledConnections.size() == 0) {
            //Spring当中的设计思想 补刀机制 代码的高可用
            System.out.println("数据库连接池没有正常初始化，将启动补刀机制再次初始化........");
            createConnections(initCount);
        }
        //线程获取连接资源 1、没有被占用  2、连接长期处于等待的时候 有可能gc 
        PooledConnection connection = getRealConnection();
        /*为什么不用if?
            n多线进入这个方法  需要cpu分配时间片  假死
            if 线程在这里醒过来connection 直接执行下面代码 Except
            while 线程在这里醒过来connection 内存地址检查
         */
        while (connection == null) {
            System.out.println("连接扩容...");
            createConnections(stepSize);
            connection = getRealConnection();
            //为了包证上层调用的对象不出现问题
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // 1、没有被占用  2、连接长期处于等待的时候 有可能超时gc
    private synchronized PooledConnection getRealConnection() {
        for (PooledConnection conn : pooledConnections) {
            //是否被线程占用
            if (!conn.isBusy()) {
                Connection connection = conn.getConnection();
                System.out.println("得到连接。。。"+conn);
                //connection是否没有超时
                try {
                    if (!connection.isValid(2000)) {
                        //替换conn对象底层java.sql.Connection
                        //直接使用最高效率底层替换
                        connection = DriverManager.getConnection(url, user, password);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //线程就不会去争抢这个资源
                conn.setBusy(true);
                return conn;
            }
        }
        return null;
    }

    @Override
    public void createConnections(int count) {
        if (poolMaxSize > 0 && pooledConnections.size() + count <= poolMaxSize) {
            for (int i = 0; i < count; i++) {
                try {
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PooledConnection pooledConnection = new PooledConnection(connection, false);
                    //线程安全集合类
                    pooledConnections.add(pooledConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("创建失败，连接数超过最大值！");
        }
        if (pooledConnections.size() == 0) {
            System.out.println("创建失败，创建连接参数非法！");
        } else {
            System.out.println("创建:" + pooledConnections.size() + "个连接");
        }
    }
}
