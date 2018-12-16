package go_offer.二叉树的镜像;

import go_offer.树的子结构.TreeNode;
import go_offer.链表.ListNode;

/**
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    public void Mirror(TreeNode root) {
        //递归边界
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
