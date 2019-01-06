package go_offer.数组中只出现一次的数字;

import java.util.HashMap;

/**
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * @create: 2019/1/6
 * @Author: SLJ
 */
public class Solution {
    /**
     * @param array 目标数组
     * @param num1 将结果保存在num1[0]
     * @param num2 将结果保存在num2[0]
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i],0 ) + 1);
        }
        boolean flag = true;
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1){
                if (flag){
                    num1[0] = i;
                    flag = false;
                }else {
                    num2[0] = i;
                }

            }
        }
    }
}
