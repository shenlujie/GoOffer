package go_offer.树的子结构;

/**
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。
 *（ps：我们约定空树不是任意一个树的子结构）
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //边界条件
        if (root1 == null || root2 == null){
            return false;
        }
        //root1和root2相等时或者不相等时判断左子树或者右子树
        return doseContain(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean doseContain(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return doseContain(root1.left, root2.left) && doseContain(root1.right, root2.right);
    }
}
