package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * Created by wx
 * Date: 2018/1/28
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1)
            set1.add(i);

        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : nums2)
            set2.add(i);

        set1.retainAll(set2);

        int[] arr = new int[set1.size()];
        int i = 0;
        for (int num : set1)
            arr[i++] = num;

        return arr;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(nums1, nums2)));
    }
}
