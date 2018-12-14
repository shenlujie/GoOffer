package go_offer.用两个栈实现队列;

import java.util.Stack;

/**
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @create: 2018/12/14
 * @Author: SLJ
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //stack1用来push
        stack1.push(node);
    }

    public int pop() {
        //当stack2空时，将stack1全部弹出到stack2中
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        //不为空时就先紧着栈里还有的元素往外弹
        return stack2.pop();
    }
}
