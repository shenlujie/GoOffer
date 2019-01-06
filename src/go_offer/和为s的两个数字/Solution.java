package go_offer.和为s的两个数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @create: 2019/1/6
 * @Author: SLJ
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //结果
        ArrayList<Integer> result = new ArrayList<>();
        //特殊情况
        if (array.length == 0){
            return result;
        }
        //map存储的是数组中每个数字以及对应的index
        HashMap<Integer,Integer> map = new HashMap<>(array.length);
        //map将array中的每个数字及其对应的index存储下来
        for (int i = 0; i < array.length; i++) {
            map.put(array[i],i );
        }
        //遍历array，每遍历到一个数字，判断sum减去该数字的差是否存在于map中
        for (int i = 0; i < array.length; i++) {
            int otherNum = sum - array[i];
            //如果该差值存在map中，说明找到了两个满足题意的数字
            if (map.containsKey(otherNum)){
                int j = map.get(otherNum);
                int product = array[i] * array[j];
                if (result.size() == 0){
                    result.add(array[i]);
                    result.add(array[j]);
                }else if (result.get(0) * result.get(1) > product){
                    result.clear();
                    result.add(array[i]);
                    result.add(array[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,16};
        List<Integer> list = new Solution().FindNumbersWithSum(arr, 10);
        for (Integer i  :list ) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
