package go_offer.把字符串转化成整数;

/**
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf ( string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 * @create: 2019/1/11
 * @Author: SLJ
 */
public class Solution {
    public int StrToInt(String str) {
        //特殊情况
        if ("".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        //最终的数字
        int sum = 0;
        //起始遍历的索引
        int startIndex;
        //首字符不符题意直接false
        if ((chars[0] != '+' && chars[0] != '-' ) && (chars[0] < '0' || chars[0] > '9')){
            return 0;
        }else if (chars[0] == '+' || chars[0] == '-'){
            //从1开始遍历
            startIndex = 1;
        }else {
            startIndex = 0;
        }
        for (int i = startIndex; i <= chars.length - 1; i++) {
            if (chars[i] < '0' || chars[i] > '9'){
                return 0;
            }
            sum = sum * 10 + (chars[i] - '0');
        }
        if (chars[0] == '-'){
            sum = sum * (-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println(new Solution().StrToInt(str));
        System.out.println(Integer.MAX_VALUE * (-1)  - 1);
    }
}
