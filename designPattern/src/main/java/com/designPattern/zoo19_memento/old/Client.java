package com.designPattern.zoo19_memento.old;

/**
 *   名称: Client.java
 *   描述: 客户端测试类
 *   类型: JAVA
 *   最近修改时间:2018/3/28 16:42
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 16:42
 *   @author gaoshudian
 */
public class Client {

    public static void main(String[] args) {

        // 创建模拟运行流程的对象
        FlowAMock mock = new FlowAMock("TestFlow");
        //运行流程的第一个阶段
        mock.runPhaseOne();
        //得到第一个阶段运行所产生的数据，后面要用
        int tempResult = mock.getTempResult();
        String tempState = mock.getTempState();
        //按照方案一来运行流程后半部分
        mock.schema1();
        //把第一个阶段运行所产生的数据重新设置回去
        mock.setTempResult(tempResult);
        mock.setTempState(tempState);
        //按照方案二来运行流程后半部分
        mock.schema2();
    }

}