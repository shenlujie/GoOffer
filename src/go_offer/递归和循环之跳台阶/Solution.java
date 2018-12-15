package go_offer.递归和循环之跳台阶;

/**
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @create: 2018/12/15
 * @Author: SLJ
 */
public class Solution {
    //dp
    public int JumpFloor(int target) {
        //特殊情况
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        int[] memo = new int[target + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= target; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[target];
    }

    public static void main(String[] args) {
        int target = 5;
        System.out.println(new Solution().JumpFloor(target));
    }
}
