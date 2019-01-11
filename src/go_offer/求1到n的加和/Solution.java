package go_offer.求1到n的加和;

/**
 * @Description: 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @create: 2019/1/11
 * @Author: SLJ
 */
public class Solution {
    /**
     * 利用逻辑&&的短路特性
     * @param n 前n个数
     * @return 加和
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = sum > 0 && (sum += Sum_Solution(--n)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().Sum_Solution(n));
    }
}
