package gao.javabase.algorithm.leetcode.linklist.phase3;

import java.util.HashMap;

/**
 * @author  gaosd
 * @description ：(LeetCode-146) LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    /*双向链表的结点定义，凡是使用过的结点都会移动到链表的头部*/
    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
    }

    /*头插法插入结点*/
    private void addNode(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /*将结点从链表摘除*/
    private void removeNode(LinkedNode node){
        LinkedNode pre = node.pre;
        LinkedNode post = node.next;
        pre.next = post;
        post.pre = pre;
    }

    /*将结点移动到头部*/
    private void moveToHead(LinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    /*移除尾部结点*/
    private LinkedNode removeTail(){
        LinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
    /*链表的头尾指针结点，不存放实际业务数据*/
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        head = new LinkedNode();
        /*用head结点的key存放容量
        * value存放当前链表中结点的实际数量*/
        head.key = capacity;
        head.value = 0;
        head.pre = null;
        tail = new LinkedNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        /*结点被使用了，移动到头部*/
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if(node == null){
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++head.value;
            if(head.value > head.key){
                /*超出了容量限制，移除尾部结点*/
                LinkedNode tail = this.removeTail();
                this.cache.remove(tail.key);
                --head.value;
            }
        }else{
            /*更新结点数据，并移动到头部*/
            node.value = value;
            this.moveToHead(node);
        }
    }
}
