package go_offer.和为s的连续整数序列;

import java.util.ArrayList;

/**
 * @Description: 小明很喜欢数学, 有一天他在做数学作业时,
 * 要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @create: 2019/1/6
 * @Author: SLJ
 */
public class Solution {
    /**
     * 滑动窗口思路
     *
     * @param sum 目标和
     * @return 结果集
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果的list
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //左指针
        int l = 1;
        //右指针
        int r = 2;
        while (l < r){
            //区间当前的和
            int curSum = (l + r) * (r - l + 1);
            //当两指针区间内的和等于sum时，说明该区间满足条件
            if (curSum == 2 * sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                result.add(list);
                l ++;
            }else if (curSum > 2 * sum){
                //如果当前区间的和大于sum
                l ++;
            }else {
                //当前区间的和小于sum
                r ++;
            }
        }
        return result;
    }
}
