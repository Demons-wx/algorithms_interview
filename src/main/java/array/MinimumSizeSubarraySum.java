package array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum >= s.
 * If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Created by wx
 * Date: 2018/1/28
 */
public class MinimumSizeSubarraySum {

    /**
     * 滑动窗口解法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while(l < nums.length) {

            // 维护一个滑动的窗口
            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];

            // 对符合条件的结果进行记录
            if (sum >= s)
                res = Math.min(res, r - l  + 1);

        }

        if (res == nums.length + 1)
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));
    }
}
