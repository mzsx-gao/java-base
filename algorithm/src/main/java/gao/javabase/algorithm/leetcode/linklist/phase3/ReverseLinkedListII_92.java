package gao.javabase.algorithm.leetcode.linklist.phase3;

import gao.javabase.algorithm.leetcode.linklist.ListNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-92) 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，
 * 返回 反转后的链表 。
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        /*将preNode移动left-1步
        *preNode的next就是反转的开始 */
        for(int i = 0; i<left-1; i++) preNode = preNode.next;

        /*要反转的链表结点就是preNode的下个结点*/
        ListNode startNode = preNode.next;
        /*同时记录要反转的下一个结点*/
        ListNode nextNode = startNode.next;

        for(int i=0; i<right-left; i++) {
            startNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
            nextNode = startNode.next;
        }
        return dummy.next;
    }
}
