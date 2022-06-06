package gao.javabase.algorithm.leetcode.linklist.phase3;

import gao.javabase.algorithm.leetcode.linklist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author  gaosd
 * @description ：(LeetCode-23) 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKSortLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /*循环+双指针解决两个链表的合并
    * 代码来自(LeetCode-21)合并两个有序链表
    * MergeTwoSortLists_21.java*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode resultNode  = new ListNode(0);
        ListNode p = resultNode ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return resultNode.next;
    }

    /*使用堆排序的思想来实现，利用了JDK中的优先队列*/
    public ListNode mergeKListsWithPQ(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        /*dummy用以返回结果链表
        *tail用以获得堆顶元素并合并链表*/
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        /*首先将所有链表的首节点放入队列，进行初始化*/
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            /*将堆顶的元素放入结果链表*/
            tail.next=queue.poll();
            tail=tail.next;
            /*将堆顶的元素的下一个结点放入队列*/
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
