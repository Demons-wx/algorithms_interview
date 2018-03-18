package search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Created by wx
 * Date: 2018/1/28
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length <= 0 || nums2.length <= 0)
            return new int[0];

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            if (map1.get(i) == null)
                map1.put(i, 1);
            else
                map1.put(i, map1.get(i) + 1);
        }

        int[] arr = new int[nums2.length];
        int index = 0;
        for (int i : nums2)
            if (map1.get(i) != null && map1.get(i) > 0) {
                arr[index++] = i;
                map1.put(i, map1.get(i) - 1);
            }

        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                end = i;
        }

        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1};

        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(nums1, nums2)));
    }
}
