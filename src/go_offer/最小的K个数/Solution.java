package go_offer.最小的K个数;

import java.util.ArrayList;

/**
 * @Description: 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @create: 2019/1/1
 * @Author: SLJ
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (input.length == 0 || k <= 0 || k > input.length){
            return list;
        }
        heapSort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void heapSort(int[] input){
        int n = input.length;

        //heapify将input数组转化为一个最大堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i --) {
            siftDown(input,n,i);
        }

        //不断的将最大的元素置于数组尾
        for (int i = n - 1; i > 0; i --) {
            //将最大元素置于数组末尾
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            //除去数组尾的元素，剩下的元素只需将头节点进行siftDown就可以转化为堆
            siftDown(input,i,0);
        }
    }

    /**
     * 下沉操作
     *
     * @param input 目标数组
     * @param n 数组长度
     * @param k 起始节点
     */
    private void siftDown(int[] input,int n,int k){
        while ((2 * k + 1) < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && input[j + 1] > input[j]){
                j = 2 * k + 2;
            }

            if (input[j] <= input[k]){
                break;
            }

            int temp = input[j];
            input[j] = input[k];
            input[k] = temp;

            k = j;
        }
    }
}
