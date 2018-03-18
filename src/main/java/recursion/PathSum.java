package recursion;

/**
 *
 * 给出一棵二叉树以及一个数字sum，判断在这棵二叉树上是否存在一条从根到叶子的路径，
 * 其路径上的所有节点和为sum
 *
 * Created by wx
 * Date: 2018/3/7
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        // 递归终止条件
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;

        return (hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val));

    }
}
