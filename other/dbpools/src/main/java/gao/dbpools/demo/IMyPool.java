package gao.dbpools.demo;

/**
 * 面向接口编程
 * 抽取连接池架构的接口
 */
public interface IMyPool {

    //获取连接  物理连接
	PooledConnection getConnection();

	//创建连接
	void createConnections(int count);
}