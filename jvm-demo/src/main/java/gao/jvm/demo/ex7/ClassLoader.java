package gao.jvm.demo.ex7;
/**
 *类加载器
 **/
public class ClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader()); //启动类加载器
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());//拓展类加载器
        System.out.println(ClassLoader.class.getClassLoader());//应用程序类加载器
    }
}
