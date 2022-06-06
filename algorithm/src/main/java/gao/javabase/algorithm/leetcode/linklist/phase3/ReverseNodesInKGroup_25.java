package gao.javabase.algorithm.leetcode.linklist.phase3;


import gao.javabase.algorithm.leetcode.linklist.ListNode;

/**
 * @author  gaosd
 * @description ：(LeetCode-25) K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        begin = dummy;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /*反转链表结点的方法*/
    public ListNode reverse(ListNode preSubList, ListNode subListNext){
        ListNode startNode = preSubList.next;
        ListNode nextNode = startNode.next;
        ListNode inPreNode = preSubList;
        while(startNode.next != subListNext){
            startNode.next = nextNode.next;
            nextNode.next = inPreNode.next;
            inPreNode.next = nextNode;
            nextNode = startNode.next;
        }
        return startNode;
    }
}
