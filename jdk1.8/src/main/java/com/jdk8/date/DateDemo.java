package com.jdk8.date;

import org.junit.Test;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *   名称: DateDemo.java
 *   描述: LocalDate,LocalTime,LocalDateTime的用法
 *   类型: JAVA
 *   最近修改时间:2018/3/14 17:05
 *   @version [版本号, V1.0]
 *   @since 2018/3/14 17:05
 *   @author gaoshudian
 */
public class DateDemo {

    /**
     * LocalDate示例
     */
    @Test
    public void testLocalDate(){
        LocalDate today = LocalDate.now();
        System.out.println("今天..."+today);

        LocalDate crischristmas = LocalDate.of(2017,12,25);
        System.out.println("实例化LocalDate对象..."+crischristmas);

        LocalDate endOfFeb = LocalDate.parse("2018-02-28");
        System.out.println("字符串转化成日期对象..."+endOfFeb);

        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("本月的第一天..."+firstDayOfThisMonth);

        LocalDate lastDayOfThisMonth =today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的最后一天..."+lastDayOfThisMonth);

        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println("本月的第二天..."+secondDayOfThisMonth);

        LocalDate priviousDay =firstDayOfThisMonth.minusDays(1);
        System.out.println("取前一天..."+priviousDay);

        LocalDate nextDay =lastDayOfThisMonth.plusDays(1);
        System.out.println("取后一天..."+nextDay);

        //取2018年3月第一个周一
        LocalDate firstMondayOf2018 = LocalDate.parse("2018-03-01")
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("2018年3月第一个周一:"+firstMondayOf2018);

        //字符串转日期格式
        System.out.println(LocalDate.parse("2018/03/14",DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(LocalDate.parse("2018-03-14",DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(LocalDate.parse("20180314",DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println(LocalDate.parse("20180314",DateTimeFormatter.BASIC_ISO_DATE));

        //日期格式转字符串
        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

    }

    /**
     * LocalTime示例
     */
    @Test
    public void testLocalTime(){

        //获取LocalTime对象
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间..."+localTime);

//        LocalTime localTime2 = LocalTime.of(18,18,40);
//        System.out.println("当前时间..."+localTime2);

        //访问LocalTime的时间
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

        //LocalTime的计算
        System.out.println("向后推一个小时.."+localTime.plusHours(1));
        System.out.println("向后推一分钟.."+localTime.plusMinutes(1));
        System.out.println("向后推一秒.."+localTime.plusSeconds(1));

        System.out.println("向前推一个小时.."+localTime.minusHours(1));
        System.out.println("向前推一分钟.."+localTime.minusMinutes(1));
        System.out.println("向前推一秒.."+localTime.minusSeconds(1));
    }

    /**
     * LocalDateTime示例
     */
    @Test
    public void testLocalDateTime(){

        //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间..."+localDateTime);
    }

}