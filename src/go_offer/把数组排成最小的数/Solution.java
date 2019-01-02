package go_offer.把数组排成最小的数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @create: 2019/1/2
 * @Author: SLJ
 */
public class Solution {
    /**
     * 存放最终结果的list
     */
    private List<List<Long>> resultList = new ArrayList<>();

    /**
     * 记录数组中每个数字是否被标记过
     */
    private boolean[] mark;

    /**
     * 找出数组中最小数字
     *
     * @param numbers 数组
     * @return 最小的数字
     */
    public String PrintMinNumber(int [] numbers) {
        //特殊情况
        if (numbers.length == 0){
            return "";
        }

        //保存每次排列结果的容器
        List<Long> list = new ArrayList<>();
        //初始化为false
        mark = new boolean[numbers.length];
        //从0开始递归排列
        findMinNumber(numbers,0,list);

        //minInteger取resultList中的第一个值
        StringBuilder sb = new StringBuilder();
        for ( Long i : resultList.get(0)) {
            sb.append(i);
        }
        long minInteger = Long.valueOf(sb.toString());

        //遍历resultList，找到最小的minInteger
        for (List<Long> curList  : resultList) {
            StringBuilder stringBuilder = new StringBuilder();
            for ( Long i : curList) {
                stringBuilder.append(i);
            }
            minInteger = Math.min(Long.valueOf(stringBuilder.toString()), minInteger);
        }
        return String.valueOf(minInteger);
    }

    private void findMinNumber(int[] numbers,int index, List<Long> list){

        //list存放够一种全排列，就将结果存入resultList
        if (list.size() == numbers.length){
            resultList.add(new ArrayList<>(list));
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!mark[i]){
                list.add((long)numbers[i]);
                mark[i] = true;

                findMinNumber(numbers, index + 1, list);
                //回溯
                list.remove(list.size() - 1);
                mark[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3334,3,3333332};
        System.out.println(new Solution().PrintMinNumber(numbers));
    }
}
