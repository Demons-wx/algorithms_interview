package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 *
 * Created by wx
 * Date: 2018/2/4
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        Map<String, String> parenthese = new HashMap<String, String>();
        parenthese.put("(", ")");
        parenthese.put("[", "]");
        parenthese.put("{", "}");

        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            if (parenthese.get(cur) != null) {
                stack.push(cur);
            } else if (stack.size() == 0 || !cur.equals(parenthese.get(stack.pop()))) {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "{[(})]";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
