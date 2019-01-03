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
public class Solution2 {
    public int GetUglyNumber_Solution(int index) {
        //特殊情况
        if (index <= 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (list.size() < index){
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2){
                i2 ++;
            }
            if (min == m3){
                i3 ++;
            }
            if (min == m5){
                i5 ++;
            }
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().GetUglyNumber_Solution(1500));
    }
}
