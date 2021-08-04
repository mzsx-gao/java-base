package gao.jvm.demo.ex8;

/**
 * 接口的调用字节码查看
 **/
public class Invoke implements I {
    @Override
    public void inf() {
    }

    public static void main(String[] args) {
        Invoke invoke = new Invoke();
        ((I) invoke).inf();
    }
}