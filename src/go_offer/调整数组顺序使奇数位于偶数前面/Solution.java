package go_offer.调整数组顺序使奇数位于偶数前面;

/**
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    /**
     * @param array 要处理的数组
     */
    public void reOrderArray(int [] array) {
        //特殊情况
        if (array.length == 0){
            return;
        }
        int VALUE = 2;
        for (int i = 1; i < array.length; i++) {
            //遍历到奇数
            if (array[i] % VALUE != 0){
                //res表示当前的奇数的值
                int res = array[i];
                int j = i;
                while (j > 0){
                    if (array[j - 1] % VALUE == 0){
                        array[j] = array[j - 1];
                        j -= 1;
                    }else {
                        break;
                    }
                }
                array[j] = res;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,3,6,7,2,8,12};
        new Solution().reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
