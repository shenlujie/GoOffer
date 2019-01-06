package go_offer.平衡二叉树;

import go_offer.树的子结构.TreeNode;

/**
 * @Description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @create: 2019/1/5
 * @Author: SLJ
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        //特殊情况
        if (root == null){
            return true;
        }else if (root.left == null && root.right == null){
            //叶子节点
            return true;
        }else {
            return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
        }
    }

    private int treeDepth(TreeNode node){
        //特殊情况
        if (node == null){
            return 0;
        }
        return Math.max(treeDepth(node.left), treeDepth(node.right)) + 1;
    }
}
