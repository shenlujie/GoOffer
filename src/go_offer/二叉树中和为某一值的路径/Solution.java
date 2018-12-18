package go_offer.二叉树中和为某一值的路径;

import go_offer.树的子结构.TreeNode;

import java.util.ArrayList;

/**
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @create: 2018/12/18
 * @Author: SLJ
 */
public class Solution {
    /**
     * 存放所有满足条件的路径
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * 存放每次遍历的一条路径
     */
    ArrayList<Integer> list = new ArrayList<>();

    /**
     * 找出所有符合条件的路径都存到array list中，并按路径长度排序
     *
     * @param root 一棵二叉树
     * @param target 目标和
     * @return 所有路径的集合
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        //特殊情况
        if (root == null){
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target < 0){
            return result;
        }
        if (target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //回溯,清除当前考虑的元素
        list.remove(list.size() - 1);
        return result;
    }
}
