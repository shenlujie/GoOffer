package go_offer.删除链表中重复的节点;

import go_offer.链表.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @create: 2019/1/8
 * @Author: SLJ
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        //特殊情况
        if (pHead == null){
            return null;
        }

        //map存储节点，以及该节点是否重复
        Map<Integer,Boolean> map = new HashMap<>();
        ListNode curNode = pHead;
        while (curNode != null){
            if (!map.containsKey(curNode.val)){
                map.put(curNode.val, false);
            }else {
                map.put(curNode.val, true);
            }
            curNode = curNode.next;
        }

        //设置虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        //再次遍历该链表
        ListNode cur = dummyHead;
        while (cur != null && cur.next != null){
            //当cur的下一个节点重复时
            ListNode e = cur.next;
            if (map.get(e.val)){
                //从cur的下一个节点开始遍历，直到一个没有重复的节点为止
                while (e.next != null && map.get(e.next.val)){
                    e = e.next;
                }
                cur.next = e.next;
                e.next = null;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1};
        ListNode pHead = new ListNode(1);
        ListNode curNode = pHead;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        System.out.println("原来的链表：");
        ListNode preCur = pHead;
        while (preCur != null){
            System.out.print(preCur.val + "\t");
            preCur = preCur.next;
        }
        System.out.println();
        ListNode head = new Solution().deleteDuplication(pHead);
        System.out.println("去重之后的链表：");
        while (head != null){
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}
