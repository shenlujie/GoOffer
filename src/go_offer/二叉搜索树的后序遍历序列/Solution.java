package go_offer.二叉搜索树的后序遍历序列;

/**
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {

    /**
     * 判断该后序遍历序列是否合法
     *
     * @param sequence 要处理的二分搜索树的后序遍历
     * @return 是否满足
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 从start开始到root，左子树的所有元素都小于root，右子树的所有值都大于root
     * 从root开始往前遍历，找到第一个比root小的位置i，start - i是左子树，i - root-1是右子树
     *
     * @param sequence 要处理的后序遍历数组
     * @param start 起始节点
     * @param root 根节点
     * @return 是否合法
     */
    private boolean VerifySquenceOfBST(int[] sequence,int start,int root){
        //递归边界
        if (start >= root){
            return true;
        }
        int i;
        for ( i = root - 1; i >= start; i --){
            if (sequence[i] < sequence[root]){
                break;
            }
        }
        for (int j = start; j <= i; j++) {
            if (sequence[j] > sequence[root]){
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, start, i) &&
                VerifySquenceOfBST(sequence, i + 1, root - 1);
    }
}
