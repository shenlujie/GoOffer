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
        //递归边界
        if (root == null){
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
