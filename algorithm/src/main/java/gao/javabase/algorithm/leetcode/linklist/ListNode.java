package gao.javabase.algorithm.leetcode.linklist;

/**
 * @author  gaosd
 * @description ：单链表中节点的定义
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
