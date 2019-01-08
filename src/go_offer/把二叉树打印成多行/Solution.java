package go_offer.把二叉树打印成多行;

import go_offer.树的子结构.TreeNode;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @create: 2019/1/8
 * @Author: SLJ
 */
public class Solution {
    /**
     * 结果集
     */
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * 层序打印二叉树的各个节点
     *
     * @param pRoot 二叉树的根节点
     * @return 结果集
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //特殊情况
        if (pRoot == null){
            return result;
        }

        //Pair一种简单的键值对，Integer表示该node的高度
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(pRoot, 0));
        while (!queue.isEmpty()){
            //取出队列首的pair
            Pair<TreeNode,Integer> pair = queue.remove();
            //从pair中取出node
            TreeNode curNode = pair.getKey();
            //从pair中取出层数
            int level = pair.getValue();
            //如果层数和结果集当前的size相同的话，就新建一个array list
            if (level == result.size()){
                result.add(new ArrayList<>());
            }
            //否则的话，当前节点还在这一层
            result.get(level).add(curNode.val);

            if (curNode.left != null){
                queue.add(new Pair<>(curNode.left, level + 1));
            }

            if (curNode.right != null){
                queue.add(new Pair<>(curNode.right, level + 1));
            }
        }
        return result;
    }
}
