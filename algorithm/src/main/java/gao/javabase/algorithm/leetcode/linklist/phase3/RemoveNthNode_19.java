package gao.javabase.algorithm.leetcode.linklist.phase3;

import gao.javabase.algorithm.leetcode.linklist.ListNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-19) 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        /*先移动快指针n步*/
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        /*同时移动快慢指针*/
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        /*去除不要的第N个结点*/
        slow.next = slow.next.next;
        return start.next;
    }
}
