package go_offer.表示数值的字符串;

/**
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @create: 2019/1/8
 * @Author: SLJ
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        boolean isSign = false;
        boolean isDecimal = false;
        boolean isE = false;

        for (int i = 0; i < str.length; i++) {
            //当前字符为e或E时
            if (str[i] == 'e' || str[i] == 'E'){
                //已经是数组末尾了，不行
                if (i == str.length - 1){
                    return false;
                }
                //前面已经有e或E了
                if (isE){
                    return false;
                }
                isE = true;
            }else if (str[i] == '+' || str[i] == '-'){
                //当前字符为+或-时

                //如果是第二次出现必须跟在e后面
                if (isSign && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                //如果第一次出现且不在数组开头，也必须跟在e后面
                if (!isSign && i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                isSign = true;
            }else if (str[i] == '.'){
                //当前字符为.时

                //e后不能出现.且.不能出现两次
                if (isE || isDecimal){
                    return false;
                }
                isDecimal = true;
            }else if (str[i] < '0' || str[i] > '9'){
                //当前字符不是数字时
                return false;
            }
        }

        return true;
    }
}
