package go_offer.数组中出现次数超过一半的数字;

import java.util.HashMap;
        import java.util.Map;

/**
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @create: 2018/12/31
 * @Author: SLJ
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        //特殊情况
        if (array.length == 0){
            return 0;
        }

        //map中存储每个元素出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        //判断map中每个元素的次数是否超过array长度的一半
        for (Integer i  : map.keySet()) {
            if (map.get(i) > array.length / 2){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,2,5,2,3};
        System.out.println(new Solution().MoreThanHalfNum_Solution(arr));
    }
}
