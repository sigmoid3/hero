package finger2offer.arr;

public class RotateMin {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        RotateMin min = new RotateMin();
        int ret = min.minNumberInRotateArray(arr);
        System.out.println(ret);
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        return findmin(array, 0, len - 1);
    }

    private int findmin(int[] array, int left, int right) {
        if (left >= right || array[left] < array[right]) {
            return array[left];
        }
        int mid;
        mid = (left + right) / 2;
        if (array[mid] > array[left]) {
            return findmin(array, mid + 1, right);
        } else if (array[mid] == array[left]) {
            return findmin(array, mid + 1, right) < findmin(array, left, mid - 1) ? findmin(array, mid + 1, right) : findmin(array, left, mid - 1);
        } else {
            return findmin(array, left, mid);
        }
    }
}