package go_offer.字符串;

/**
*@Description: 替换空格
*@create: 2018/10/23
*@Author: SLJ
*/
public class Solution {

    public static void main(String[] args){
        StringBuffer str = new StringBuffer("a b c d e");
        System.out.print(replaceSpace(str));
    }
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}
