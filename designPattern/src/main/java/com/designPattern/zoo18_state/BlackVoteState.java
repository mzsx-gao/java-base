package com.designPattern.zoo18_state;

/**
 *   名称: BlackVoteState.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/28 14:33
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 14:33
 *   @author gaoshudian
 */

public class BlackVoteState implements VoteState{
    public void vote(String user, String voteItem,VoteManager voteManager) {
        //黑名单
        //记入黑名单中，禁止登录系统了
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}