package go_offer.链表;

import java.util.ArrayList;
import java.util.Stack;

/**
*@Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
*@create: 2018/10/23
*@Author: SLJ
*/
public class Solution {

    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        for (int i = 0; i < printListFromTailToHead(listNode).size(); i++) {
            System.out.print(printListFromTailToHead(listNode).get(i) + "   ");
        }

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;
    }
}
