package go_offer.链表中倒数第k个结点;

import go_offer.链表.ListNode;

/**
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    /**
     * @param head 链表的头节点
     * @param k 倒数k
     * @return 倒数k的节点
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        //特殊情况
        if (head == null || k == 0){
            return null;
        }
        ListNode cur = head;
        //第一次遍历求链表长度
        int len = 1;
        while (cur.next != null){
            len ++;
            cur = cur.next;
        }
        //特殊情况
        if (k > len){
            return null;
        }
        for (int i = 1; i <= len - k; i++) {
            head = head.next;
        }
        return head;
    }
}
