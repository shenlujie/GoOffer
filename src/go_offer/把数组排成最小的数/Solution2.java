package go_offer.把数组排成最小的数;

import java.util.Arrays;

/**
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @create: 2019/1/2
 * @Author: SLJ
 */
public class Solution2 {

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

        //将numbers数组转化为String数组
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        //利用comparator对strs进行比较（天秀）
        Arrays.sort(strs, (o1,o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return a.compareTo(b);
        });

        //用StringBuilder将排好序的strs串联起来
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
