package go_offer.字符串的排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 *
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @create: 2018/12/31
 * @Author: SLJ
 */
public class Solution {
    /**
     * 用于存放最终结果的list
     */
    ArrayList<List<Character>> resultList = new ArrayList<>();

    /**
     * 用于存放元素是否被访问标记
     */
    boolean[] mark;

    /**
     * 求出str的所有全排列
     * @param str 字符串
     * @return 全排列字符串存入result
     */
    public ArrayList<String> Permutation(String str) {
        //要返回的最终结果
        ArrayList<String> result = new ArrayList<>();

        //递归处理的字符数组
        char[] arr = str.toCharArray();

        //元素标记数组,默认全为false
        mark = new boolean[arr.length];

        //用于存放当前排列情况的list
        List<Character> list = new ArrayList<>();

        //特殊情况
        if (str == null || "".equals(str)){
            return result;
        }

        //从0开始递归
        findPermutation(arr,0,list);

        //将resultList中存放的字符数组转化为result
        for (List<Character> list1 : resultList) {
            StringBuilder sb = new StringBuilder();
            for (char e  : list1) {
                sb.append(e);
            }
            if (!result.contains(sb.toString())){
                result.add(sb.toString());
            }
        }
        return result;
    }

    /**
     * 递归将所有可能情况存入list
     * @param arr 字符数组
     * @param index 当前考虑元素
     * @param list 用于存放当前排列情况的list
     */
    private void findPermutation(char[] arr,int index,List<Character> list){
        //当list的容量和arr长度一致时，说明已找到一组arr的排列方式
        if (list.size() == arr.length){
            List<Character> newList = new ArrayList<>(list);
            resultList.add(newList);
        }

        //每个元素都有作为第一个元素的机会
        for (int i = 0; i < arr.length; i++) {
            if (!mark[i]){
                list.add(arr[i]);
                mark[i] = true;
                findPermutation(arr, index + 1, list);
                //回溯
                mark[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
