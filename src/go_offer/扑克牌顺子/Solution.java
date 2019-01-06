package go_offer.扑克牌顺子;

import java.util.Arrays;

/**
 * @Description: LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * @create: 2019/1/6
 * @Author: SLJ
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        //特殊情况
        if (numbers.length == 0){
            return false;
        }
        if (numbers.length == 1){
            return true;
        }

        //统计0的个数
        int zeroSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                zeroSum ++;
            }
        }

        //特殊情况，如果抽出的牌全是0或者就一个非0的牌，那肯定成啊
        if (zeroSum == numbers.length || zeroSum == numbers.length - 1){
            return true;
        }

        //把数组排序，0肯定在前面
        Arrays.sort(numbers);

        //非0数之间的差距（gap 缝隙）
        int gap = 0;
        int i = zeroSum,j = zeroSum + 1;

        //遍历数组，统计总差值
        while (i <= numbers.length - 2 && j <= numbers.length - 1){
            if (numbers[j] - numbers[i] == 0){
                return false;
            }
            gap += numbers[j] - numbers[i] - 1;
            i ++;
            j ++;
        }

        //判断差值和0个数的关系
        return gap == zeroSum;
    }
}
