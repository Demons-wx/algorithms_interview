package array;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * <p>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Created by wx
 * Date: 2018/1/28
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 滑动窗口法
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0, r = -1; // 滑动窗口为s[l...r]
        int res = 0;

        while (l < s.length()) {
            // 维护窗口
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
                freq[s.charAt(++r)]++;
            else
                freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring(s));
    }
}
