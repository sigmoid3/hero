package finger2offer.search;

import java.util.Arrays;

/**
 * BinaryChop search
 */
public class BinaryChop {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 3};
        int ret1 = binaryChop(arr, 3);
        System.out.println(ret1);
    }

    private static int binaryChop(int[] arr, int target) {
        Arrays.sort(arr);
        int ret = binaryAdjust(arr, target, 0, arr.length - 1);
        return ret;
    }

    private static int binaryAdjust(int[] arr, int target, int left, int right) {
        int mid = (right + left) / 2;
        if (right - left < 1 && arr[mid] != target) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binaryAdjust(arr, target, mid + 1, right);
        } else {
            return binaryAdjust(arr, target, left, mid - 1);
        }
    }
}