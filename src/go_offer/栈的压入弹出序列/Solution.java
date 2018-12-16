package go_offer.栈的压入弹出序列;

import java.util.Stack;

/**
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //特殊情况
        if (pushA.length == 0 || popA.length == 0){
            return false;
        }
        //开辟一个辅助空间
        Stack<Integer> stack = new Stack<>();
        //i用来遍历pushA,j用来记录popA出栈的位置
        int i = 0;
        int j = 0;
        while (i < pushA.length){
            stack.push(pushA[i ++]);
            while (!stack.empty() && stack.peek().equals(popA[j])){
                stack.pop();
                j ++;
            }
        }
        return stack.empty();
    }
}
