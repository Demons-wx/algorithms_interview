package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Created by wx
 * Date: 2018/2/4
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> right = new Stack<TreeNode>();

        while (root != null) {
            result.add(root.val);

            if (root.right != null)
                right.push(root.right);

            root = root.left;
            if (root == null && !right.isEmpty()) {
                root = right.pop();
            }
        }

        return result;
    }
}
