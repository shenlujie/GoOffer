package go_offer.字符流中第一个不重复的字符;

/**
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @create: 2019/1/8
 * @Author: SLJ
 */
public class Solution {

    /**
     * 存储字符的数组（index是字符对应的ASCII码）
     */
    private int[] chars = new int[256];

    /**
     * 初始字符串
     */
    private String string = "";

    /**
     * Insert one char from stringstream
     *
     * @param ch 字符流中插入的字符
     */
    public void Insert(char ch) {
        //将字符拼接到字符串中
        string += ch;
        //将字符出现的频率进行统计
        chars[ch] ++;
    }

    /**
     * 找出第一个整个字符串只出现一次的字符
     *
     * @return the first appearence once char in current stringstream
     */
    public char FirstAppearingOnce() {
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (chars[arr[i]] == 1){
                return arr[i];
            }
        }
        return '#';
    }
}
