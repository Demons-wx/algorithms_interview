package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Created by wx
 * Date: 2018/3/7
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null)
            return res;

        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftS = binaryTreePaths(root.left);
        for (int i = 0; i < leftS.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + leftS.get(i));
        }

        List<String> rightS = binaryTreePaths(root.right);
        for (int i = 0; i < rightS.size(); i++) {
            res.add(String.valueOf(root.val) + "->" + rightS.get(i));
        }

        return res;
    }
}
