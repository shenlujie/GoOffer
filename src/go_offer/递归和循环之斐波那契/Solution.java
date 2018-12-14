package go_offer.递归和循环之斐波那契;

/**
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @create: 2018/12/14
 * @Author: SLJ
 */
public class Solution {
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2;i <= n;i ++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
