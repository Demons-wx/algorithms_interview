package stack;

/**
 * Created by wx
 * Date: 2018/2/4
 */
public class Command {

    public String s;
    public TreeNode node;

    public Command(String command, TreeNode node) {
        this.s = command;
        this.node = node;
    }
}
