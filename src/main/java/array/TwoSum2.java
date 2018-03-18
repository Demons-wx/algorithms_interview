package array;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Created by wx
 * Date: 2018/1/28
 */
public class TwoSum2 {

    /**
     * 对撞指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] arr = {0, 0};

        while (i < j) {

            int num = numbers[i] + numbers[j];

            if (num == target) {
                arr[0] = i + 1;
                arr[1] = j + 1;
                return arr;
            } else if (num > target) {
                j--;
            } else {
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum2().twoSum(numbers, 9)));
    }
}
