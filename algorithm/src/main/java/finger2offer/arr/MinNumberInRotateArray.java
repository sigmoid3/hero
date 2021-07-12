package finger2offer.arr;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 2, 3};
        int ret = minNumberInRotateaArray(arr);
        System.out.println(ret);
    }

    private static int minNumberInRotateaArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        return findMin(array, 0, len - 1);
    }

    private static int findMin(int[] array, int left, int right) {
        if (left >= right || array[left] < array[right]) {
            return array[left];
        }
        int mid;
        mid = (left + right) / 2;
        if (array[mid] > array[left]) {
            return findMin(array, mid + 1, right);
        } else if (array[mid] == array[left]) {
            return findMin(array, mid + 1, right) < findMin(array, left, mid - 1) ? findMin(array, mid + 1, right) : findMin(array, left, mid - 1);
        } else {
            return findMin(array, left, mid);
        }
    }
}