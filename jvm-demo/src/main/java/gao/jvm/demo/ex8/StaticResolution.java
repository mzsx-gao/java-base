package gao.jvm.demo.ex8;
/**
 * 非虚方法的调用
 **/
public class StaticResolution {
    public static void Hello(){
        System.out.println("hello King");
    }

    public static void main(String[] args) {
        StaticResolution.Hello();
        StaticResolution staticResolution = new StaticResolution();
    }
}
