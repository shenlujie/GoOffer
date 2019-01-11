package go_offer.不用加减乘除做加法;

/**
 * @Description: 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 * @create: 2019/1/11
 * @Author: SLJ
 */
public class Solution {
    public int Add(int num1,int num2) {
        while (num2 != 0){
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        System.out.println(new Solution().Add(a, b));
    }
}
