package go_offer.数组中的逆序对;

/**
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 *
 * 输入
 * 1,2,3,4,5,6,7,0
 *
 * 输出
 * 7
 * @create: 2019/1/4
 * @Author: SLJ
 */
public class Solution {
    /**
     * 逆序对总个数
     */
    int result;

    public int InversePairs(int [] array) {
        //特殊情况
        if (array.length == 0){
            return 0;
        }

        mergeSort(array,0,array.length - 1);
//        result %= 1000000007;
        return result;
    }

    private void mergeSort(int[] array,int l, int r){
        if (l >= r){
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(array,l ,mid );
        mergeSort(array,mid + 1 ,r );
        merge(array,l,mid,r);
    }

    private void merge(int[] array,int l,int mid, int r){
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = array[i];
        }
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r ; k++) {
            if (i > mid){
                array[k] = aux[j - l];
                j ++;
            }else if (j > r){
                array[k] = aux[i - l];
                i ++;
            }else if (aux[i - l] <= aux[j - l]){
                array[k] = aux[i - l];
                i ++;
            }else {
                //核心代码：l - mid的数组是递增的，mid+1 - r的数组也是递增的
                //如果aux[i - l] > aux[j - l]，那么i - mid的数组所有的数都大于aux[j - l]
                //result的个数增加mid - i + 1
                result += mid - i + 1;
                result %= 1000000007;
                array[k] = aux[j - l];
                j ++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(new Solution().InversePairs(arr));
    }
}
