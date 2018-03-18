package recursion;

/**
 *
 * 翻转一棵二叉树
 * Created by wx
 * Date: 2018/3/7
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);

        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

}
