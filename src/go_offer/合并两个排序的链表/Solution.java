package go_offer.合并两个排序的链表;

import go_offer.链表.ListNode;
import go_offer.链表.ListNodeHelper;

/**
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    /**
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        //初始化mergeList头节点
        int value;
        if (list1.val <= list2.val){
            value = list1.val;
            list1 = list1.next;
        }else {
            value = list2.val;
            list2 = list2.next;
        }
        ListNode mergeList = new ListNode(value);
        ListNode head = mergeList;
        //遍历list1和list2
        while (list1 != null && list2 != null){
            int curVal;
            if (list1.val <= list2.val){
                curVal = list1.val;
                list1 = list1.next;
            }else {
                curVal = list2.val;
                list2 = list2.next;
            }
            ListNode cur = new ListNode(curVal);
            head.next = cur;
            //维护head
            head = cur;
        }
        //list1走到头了，list2还没到头
        if (list1 == null && list2 != null){
            head.next = list2;
        }

        //list2走到头了，list1还没到头
        if (list2 == null && list1 != null){
            head.next = list1;
        }

        return mergeList;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        ListNode list1 = ListNodeHelper.toListNode(a);
        ListNode list2 = ListNodeHelper.toListNode(b);
        ListNode mergeList = new Solution().Merge(list1, list2);
        ListNodeHelper.printListNode(mergeList);
    }
}
