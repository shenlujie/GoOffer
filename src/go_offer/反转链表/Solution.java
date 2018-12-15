package go_offer.反转链表;

import go_offer.链表.ListNode;

/**
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 * @create: 2018/12/15
 * @Author: SLJ
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
