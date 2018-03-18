package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by wx
 * Date: 2018/1/7
 */
public class MoveZeros {

    public void moveZeros(int[] nums) {

        List<Integer> nonZeroElements = new ArrayList<Integer>();

        for (int i : nums) {
            if (i != 0)
                nonZeroElements.add(i);
        }

        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeros2(int[] nums) {

        int k = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[k] = i;
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeros3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k)
                    swap(nums, k++, i);
                else
                    k++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        new MoveZeros().moveZeros3(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }
}
