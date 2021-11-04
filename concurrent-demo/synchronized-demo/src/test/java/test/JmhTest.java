package test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 名称: test.JmhTest
 * 描述: JMH测试
 *
 * @author gaoshudian
 * @date 2021/8/16 21:25
 */

@BenchmarkMode(Mode.AverageTime)//测试模型，计算平均时间
@Warmup(iterations = 3)//预热
@Measurement(iterations = 5)//一共执行多少次
@Fork(1)//fork两个进程
//@Threads(1)//每个进程中的测试线程
@OutputTimeUnit(TimeUnit.NANOSECONDS)//时间单位
public class JmhTest {

    static int i = 0;

    @Benchmark
    public void a() {
        i++;
    }

    //这两个方法差不多，因为jit对代码做了优化，锁消除
    @Benchmark
    public void b() {
        Object o = new Object();
        synchronized (o) {
            i++;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhTest.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}