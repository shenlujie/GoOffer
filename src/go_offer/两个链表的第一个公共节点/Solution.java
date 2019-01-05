package go_offer.两个链表的第一个公共节点;

import go_offer.链表.ListNode;

/**
 * @Description: 两个链表的第一个公共节点
 * @create: 2019/1/5
 * @Author: SLJ
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //特殊情况
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        //pHead1的长度
        int count1 = 0;
        ListNode cur1 = pHead1;
        //pHead2的长度
        int count2 = 0;
        ListNode cur2 = pHead2;

        //计算pHead1的长度
        while (cur1 != null){
            count1 ++;
            cur1 = cur1.next;
        }
        //计算pHead2的长度
        while (cur2 != null){
            count2 ++;
            cur2 = cur2.next;
        }

        if (count1 > count2){
            int distance = count1 - count2;
            for (int i = 0; i < distance; i++) {
                pHead1 = pHead1.next;
            }

            while (pHead1 != pHead2){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }else if (count1 < count2){
            int distance = count2 - count1;
            for (int i = 0; i < distance; i++) {
                pHead2 = pHead2.next;
            }

            while (pHead2 != pHead1){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead2;
        }else {
            while (pHead1 != pHead2){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
    }
}
