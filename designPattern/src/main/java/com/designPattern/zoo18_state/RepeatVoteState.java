package com.designPattern.zoo18_state;

/**
 *   名称: RepeatVoteState.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/28 14:32
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 14:32
 *   @author gaoshudian
 */

public class RepeatVoteState implements VoteState{
    public void vote(String user, String voteItem,VoteManager voteManager) {
        //重复投票
        //暂时不做处理
        System.out.println("请不要重复投票");
    }
}