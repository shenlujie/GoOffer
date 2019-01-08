package go_offer.链表的入口节点;

import go_offer.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @create: 2019/1/8
 * @Author: SLJ
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //特殊情况
        if (pHead == null){
            return null;
        }

        //存放各个节点的set
        Set<ListNode> set = new HashSet<>();

        ListNode curNode = pHead;
        while (curNode != null){
            if (set.contains(curNode)){
                return curNode;
            }
            set.add(curNode);
            curNode = curNode.next;
        }
        return null;
    }
}
