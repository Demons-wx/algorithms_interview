package array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * Created by wx
 * Date: 2018/1/28
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int i : nums) {
            assert(i >= 0 && i <= 2);
            count[i]++;
        }

        int index = 0;
        int j = 0;
        for (int i = 0; i < count.length; i++) {

            j += count[i];
            while(index < j) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 三路快排思路
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
                swap(nums, i, --two);
            else {
                assert(nums[i] == 0);
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 1, 2};
        new SortColors().sortColors(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }
}
