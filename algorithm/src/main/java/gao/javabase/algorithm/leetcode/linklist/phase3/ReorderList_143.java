package gao.javabase.algorithm.leetcode.linklist.phase3;

import gao.javabase.algorithm.leetcode.linklist.ListNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-143) 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *  L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        /*寻找链表的中间结点，和876不同
        这里如果结点数是偶数个，
        返回的是中间结点的第一个结点*/
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        /*反转后半部分链表*/
        ListNode preMiddle=slow;
        ListNode preCurrent=slow.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        /*“梅花间隔”的形式将反转后的链表插入到前半部分链表*/
        slow=head;
        fast=preMiddle.next;
        while(slow!=preMiddle){
            preMiddle.next=fast.next;
            fast.next=slow.next;
            slow.next=fast;
            slow=fast.next;
            fast=preMiddle.next;
        }
    }
}
