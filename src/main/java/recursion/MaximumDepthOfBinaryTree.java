package recursion;

/**
 * 求一颗二叉树的最高深度，从根节点到叶子节点最长路径长度
 * Created by wx
 * Date: 2018/3/5
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);

        return Math.max(leftLength, rightLength) + 1;
    }

    public static void main(String[] args) {

    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}