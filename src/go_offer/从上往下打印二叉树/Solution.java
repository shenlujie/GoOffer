package go_offer.从上往下打印二叉树;

import go_offer.树的子结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //将结果存入result
        ArrayList<Integer> result = new ArrayList<>();
        //特殊情况
        if (root == null){
            return result;
        }
        //使用队列尽心层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            result.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return result;
    }
}
