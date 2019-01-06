package go_offer.左旋字符串;

/**
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @create: 2019/1/6
 * @Author: SLJ
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        //特殊情况
        if ("".equals(str)){
            return "";
        }
        if (n == 0){
            return str;
        }

        //substring(beginIndex,endIndex)
        //该方法左闭右开
        String preSubString = str.substring(0, n);
        String lateSubString = str.substring(n,str.length());
        StringBuilder sb = new StringBuilder();
        sb.append(lateSubString);
        sb.append(preSubString);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(new Solution().LeftRotateString(str, 3));
    }
}
