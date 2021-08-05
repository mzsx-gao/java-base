package gao.jvm.demo.ex8;
/**
 * Lambda表达式字节码查看
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
    }
}