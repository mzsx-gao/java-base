package com.designPattern.zoo18_state;

/**
 *   名称: SpiteVoteState.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/28 14:32
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 14:32
 *   @author gaoshudian
 */
public class SpiteVoteState implements VoteState{
    public void vote(String user, String voteItem,VoteManager voteManager) {
        //恶意投票
        //取消用户的投票资格，并取消投票记录
        String s = voteManager.getMapVote().get(user);
        if(s!=null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷票行为，取消投票资格");
    }
}