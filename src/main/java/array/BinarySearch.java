package array;

/**
 * Created by wx
 * Date: 2018/1/7
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int n, int target) {

        int l = 0, r = n - 1; // 在[l...r]的范围里寻找target
        while (l <= r) { // 当l=r时，区间[l...r]依然是有效的
            int mid = l + (r - l) / 2; // 为了避免整数溢出问题
            if (arr[mid] == target)
                return mid;
            if (target > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}
