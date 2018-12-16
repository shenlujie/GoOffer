package go_offer.二进制中1的个数;

/**
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @create: 2018/12/15
 * @Author: SLJ
 */
public class Solution {
    /**
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        if (n == 0){
            return 0;
        }
        int result = 0;
        String bString = Integer.toBinaryString(n);
        for (int i = 0; i < bString.length(); i++) {
            if (bString.charAt(i) == '1'){
                result ++;
            }
        }
        return result;
    }

    /**
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new Solution().NumberOf1(n));
        System.out.println(Integer.toBinaryString(-3));
    }
}
