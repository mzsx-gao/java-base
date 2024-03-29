package go.concurrent.cha.cfdemo.flow;

import go.concurrent.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：取最快消费类
 */
public class AcceptEither {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "s1";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "hello world";
        }), (s)-> System.out.println(s));
        SleepTools.second(3);
    }
}
