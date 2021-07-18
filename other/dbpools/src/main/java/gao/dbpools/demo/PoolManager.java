package gao.dbpools.demo;

/**
 * 内部类单例模式来对外提供连接池对象 
 * 严格保证线程安全机制
 *
 * 单利模式还不能完全防御死多线程环境下创建多份实例的情况
 * 双重判断if（）单例模型
 * 有可能  jvm 当形成两处实例对象 多占用服务器资源（细节）
 * 判断之后 
 * 合并返回一个实例
 * ClaasLoader
 */
public class PoolManager {

    private static class createPool {
        private static MyPoolImpl poolImpl = new MyPoolImpl();
    }
    
    /**
     * jvm当中类加器加载字节码是一个严格互斥理论模型 
     * 类加载器原理 完美的实现线程安全
     * 
     * @return
    */
    public static MyPoolImpl getInstace() {
        return createPool.poolImpl;
    }
}
