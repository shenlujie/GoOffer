package go_offer.数值的整数次方;

/**
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {

    /**
     * @param base 基数
     * @param exponent 指数
     * @return 返回base的exponent次方
     */
    public double Power1(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent < 0){
            result = 1 / result;
        }
        return result;
    }

    /**
     * @param base 基数
     * @param exponent 指数
     * @return 返回base的exponent次方
     */
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Power1(2, -3));
    }
}
