package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 通过自己模拟栈的操作，可以方便的构造前/中/后序遍历二叉树
 * Created by wx
 * Date: 2018/2/4
 */
public class BinaryTreeOrderTraversal {

    // 要改为中序遍历和后序遍历，只需要调整1，2，3的顺序即可
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command command = stack.pop();

            if ("print".equals(command.s)) {
                res.add(command.node.val);
            }else {
                assert ("go".equals(command.s));

                if (command.node.right != null) // 1
                    stack.push(new Command("go", command.node.right));
                if (command.node.left != null) // 2
                    stack.push(new Command("go", command.node.left));
                stack.push(new Command("print", command.node)); // 3
            }
        }
        return res;
    }
}
