package go_offer.包含min函数的栈;

import java.util.Stack;

/**
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 *（时间复杂度应为O（1））。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * @param node 要添加的元素
     */
    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()){
            stack2.push(node);
        }else {
            if (stack2.peek() >= node){
                stack2.push(node);
            }
        }

    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
