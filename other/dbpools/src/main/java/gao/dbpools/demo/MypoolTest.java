package gao.dbpools.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 检验产品是否成功
 */
public class MypoolTest {

    // 拿到连接池对象
    private static MyPoolImpl orcl = PoolManager.getInstace();
    
    /**
     * 单个线程使用连接池对象做查询业务
     */
    public synchronized static void selctData() {
        PooledConnection connection = orcl.getConnection();
        ResultSet rs = connection.queryBysql("SELECT * FROM book");
        System.out.println("线程名称： " + Thread.currentThread().getName());
        try {
            while (rs.next()) {
                System.out.print(rs.getString("id") + "\t\t");
                System.out.print(rs.getString("isbn") + "\t\t");
                System.out.println();
            }
            //复用功能没有了
            rs.close();
            //释放线程占用的状态 复用功能完全关闭
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // 玩的大 new 2350 客户端
        for (int i = 0; i < 100; i++) {
            new Thread(()->selctData()).start();
        }
    }
    
}