

#JMH注解介绍:
####@BenchmarkMode
基准测试类型。这里选择的是Throughput也就是吞吐量。根据源码点进去，每种类型后面都有对应的解释，比较好理解，吞吐量会得到单位时间内可以进行的操作数。
    Throughput: 整体吞吐量，例如“1秒内可以执行多少次调用”。
    AverageTime: 调用的平均时间，例如“每次调用平均耗时xxx毫秒”。
    SampleTime: 随机取样，最后输出取样结果的分布，例如“99%的调用在xxx毫秒以内，99.99%的调用在xxx毫秒以内”
    SingleShotTime: 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为0，用于测试冷启动时的性能。
    All(“all”, “All benchmark modes”);
    
####@Warmup
上面我们提到了，进行基准测试前需要进行预热。一般我们前几次进行程序测试的时候都会比较慢，所以要让程序进行几轮预热，保证测试的准确性。
其中的参数iterations也就非常好理解了，就是预热轮数。
为什么需要预热？因为 JVM 的 JIT 机制的存在，如果某个函数被调用多次之后，JVM会尝试将其编译成为机器码从而提高执行速度。
所以为了让 benchmark 的结果更加接近真实情况就需要进行预热。
    iterations：预热的次数。
    time：每次预热的时间。
    timeUnit：时间的单位，默认秒。
    batchSize：批处理大小，每次操作调用几次方法。
    
####@Measurement
度量，其实就是一些基本的测试参数。可以根据具体情况调整。一般比较重的东西可以进行大量的测试，放到服务器上运行。
    iterations 进行测试的轮次
    time 每轮进行的时长
    timeUnit 时长单位

####@Fork
进行 fork 的次数。可用于类或者方法上。如果 fork 数是2的话，则 JMH 会 fork 出两个进程来进行测试。

####@Threads
每个进程中的测试线程，可用于类或者方法上。一般选择为cpu乘以2。如果配置了 Threads.MAX ，代表使用 Runtime.getRuntime().availableProcessors() 个线程。



####@OutputTimeUnit
这个比较简单了，基准测试结果的时间类型。一般选择秒、毫秒、微秒。

@Benchmark
方法级注解，表示该方法是需要进行 benchmark 的对象，用法和 JUnit 的 @Test 类似。

@Param
属性级注解，@Param 可以用来指定某项参数的多种情况。特别适合用来测试一个函数在不同的参数输入的情况下的性能。

@Setup
方法级注解，这个注解的作用就是我们需要在测试之前进行一些准备工作，比如对一些数据的初始化之类的。

@TearDown
方法级注解，这个注解的作用就是我们需要在测试之后进行一些结束工作，比如关闭线程池，数据库连接等的，主要用于资源的回收等。

@Setup主要实现测试前的初始化工作，只能作用在方法上。用法和Junit一样。使用该注解必须定义 @State注解。

@TearDown主要实现测试完成后的垃圾回收等工作，只能作用在方法上。用法和Junit一样。使用该注解必须定义 @State 注解。

这两个注解都有一个 Level 的枚举value，它有三个值（默认的是Trial）：

Trial：在每次Benchmark的之前/之后执行。
Iteration：在每次Benchmark的iteration的之前/之后执行。
Invocation：每次调用Benchmark标记的方法之前/之后都会执行。
可见，Level的粒度从Trial到Invocation越来越细。

@State
当使用@Setup参数的时候，必须在类上加这个参数，不然会提示无法运行。

State 用于声明某个类是一个“状态”，然后接受一个 Scope 参数用来表示该状态的共享范围。 因为很多 benchmark 会需要一些表示状态的类，JMH 允许你把这些类以依赖注入的方式注入到 benchmark 函数里。Scope 主要分为三种。

Thread: 该状态为每个线程独享。
Group: 该状态为同一个组里面所有线程共享。
Benchmark: 该状态在所有线程间共享。