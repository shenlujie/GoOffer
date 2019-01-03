package go_offer.丑数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @create: 2019/1/3
 * @Author: SLJ
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        List<Integer> list = new ArrayList<>();
        int i = 2;
        list.add(1);
        while (true){
            if (list.size() == index){
                break;
            }
            if (isUglyNum(i)){
                list.add(i);
            }
            i ++;
        }
        return list.get(index - 1);
    }

    private boolean isUglyNum(int i){
        while (i % 2 == 0){
            i /= 2;
        }
        while (i % 3 == 0){
            i /= 3;
        }
        while (i % 5 == 0){
            i /= 5;
        }
        return i == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(1500));
    }
}
