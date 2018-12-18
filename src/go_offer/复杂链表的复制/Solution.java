package go_offer.复杂链表的复制;

import java.util.HashMap;

/**
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 *（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @create: 2018/12/18
 * @Author: SLJ
 */
public class Solution {
    /**
     * 将要克隆的链表和已知链表存进map形成对应关系
     * 先利用while循环将next进行复制，最后利用map的对应关系对random进行复制
     *
     * @param pHead 复杂的链表
     * @return 复制的链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        //特殊情况
        if (pHead == null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode nHead = new RandomListNode(pHead.label);
        //开辟新的引用进行操作，pHead和nHead要始终保持不变
        RandomListNode pHeadNew = pHead;
        RandomListNode nHeadNew = nHead;
        map.put(pHeadNew, nHeadNew);

        //循环将next进行复制
        while (pHeadNew.next != null){
            nHeadNew.next = new RandomListNode(pHeadNew.next.label);
            pHeadNew = pHeadNew.next;
            nHeadNew = nHeadNew.next;
            map.put(pHeadNew, nHeadNew);
        }

        pHeadNew = pHead;
        nHeadNew = nHead;
        //利用map的对应关系将random进行复制
        while (nHeadNew != null){
            nHeadNew.random = map.get(pHeadNew.random);
            nHeadNew = nHeadNew.next;
            pHeadNew = pHeadNew.next;
        }
        return nHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
