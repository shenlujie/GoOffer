package go_offer.链表;

/**
 * @Description: 有关链表问题的工具类
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class ListNodeHelper {

    /**
     * @param a 一个int型的数组
     * @return a数组转化成的链表
     */
    public static ListNode toListNode(int[] a){
        ListNode list = new ListNode(a[0]);
        ListNode head = list;
        for (int i = 1; i < a.length; i++) {
            ListNode curNode = new ListNode(a[i]);
            head.next = curNode;
            head = curNode;
        }
        return list;
    }

    /**
     * @param list 一个链表
     */
    public static void printListNode(ListNode list){
        while (list != null){
            System.out.print(list.val + "\t");
            list = list.next;
        }
        System.out.println();
    }
}
