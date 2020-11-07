package go.multithread.base.annotation.processor;

/**
 * @Description: 主类
 *
 * @Auther: gaoshudian
 * @Date: 2018/12/16 21:56
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("success");
        test();
    }

    @Test(value="method is test")
    public static void test(){

    }
}
