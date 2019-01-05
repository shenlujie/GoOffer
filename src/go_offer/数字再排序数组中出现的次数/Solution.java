package go_offer.数字再排序数组中出现的次数;

import java.util.Arrays;

/**
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @create: 2019/1/5
 * @Author: SLJ
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        //不管array是从小到大还是从大到小，都统一成从小到大
        Arrays.sort(array);
        //特殊情况
        if (array.length ==0){
            return 0;
        }
        if (k < array[0] || k > array[array.length - 1]){
            return 0;
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k){
                result ++;
            }
        }
        return result;
    }
}
