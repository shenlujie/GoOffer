package go_offer.递归和循环之矩形覆盖;

/**
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @create: 2018/12/15
 * @Author: SLJ
 */
public class Solution {
    //dp
    //还是斐波那契思路
    //摆放第n块时，可能是竖着的，就是memo[n-1]；可能是横着的，就是memo[n-2]
    //（因为如果是横着放，下面那个块的摆放形式也就确定了）
    public int RectCover(int target) {
        //特殊情况
        if (target == 0){
            return 0;
        }
        if (target*2 == 2){
            return 1;
        }
        int[] memo = new int[target + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= target; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[target];
    }
}
