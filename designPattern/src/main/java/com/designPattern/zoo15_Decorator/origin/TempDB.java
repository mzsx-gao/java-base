package com.designPattern.zoo15_Decorator.origin;

import java.util.HashMap;
import java.util.Map;

/**
 *   名称: TempDB.java <br>
 *   描述: 在内存中模拟数据库，准备点测试数据，好计算奖金<br>
 *   类型: JAVA <br>
 *   最近修改时间:2017/8/23 14:38.<br>
 *   @version [版本号, V1.0]
 *   @since 2017/8/23 14:38.
 *   @author gaoshudian
 */
public class TempDB {

    private TempDB(){

    }
    /**
     * 记录每个人的月度销售额，只用了人员，月份没有用
     */
    public static Map<String,Double> mapMonthSaleMoney = new HashMap<String,Double>();
    static{
        //填充测试数据
        mapMonthSaleMoney.put("张三",10000.0);
        mapMonthSaleMoney.put("李四",20000.0);
        mapMonthSaleMoney.put("王五",30000.0);
    }
}