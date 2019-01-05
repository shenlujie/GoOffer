package go_offer.二叉树的深度;

import go_offer.树的子结构.TreeNode;

/**
 * @Description: 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @create: 2019/1/5
 * @Author: SLJ
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        //特殊情况
        if (root == null){
            return 0;
        }

        return treeDepth(root);
    }

    private int treeDepth(TreeNode root){
        //左右子树都为空
        if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null && root.right != null){
            //左子树为空右子树不为空
            return treeDepth(root.right) + 1;
        }else if (root.right == null && root.left != null){
            //左子树不为空右子树为空
            return treeDepth(root.left) + 1;
        }else {
            //左右子树都不为空
            return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
        }
    }
}
