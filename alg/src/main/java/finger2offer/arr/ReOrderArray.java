package finger2offer.arr;

public class ReOrderArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 1};
        reOrderArray2(arr);
        for (int v : arr) {
            System.out.printf("%d ", v);
        }
    }

    public static void reOrderArray1(int[] array) {
        int len = array.length;
        if (len == 1) {
            return;
        }
        int idxR = len;
        for (int i = len - 1; i >= 0; i--) {
            //move the even number
            if (array[i] % 2 == 0) {
                for (int j = i; j < idxR - 1; j++) {
                    swap(array, j, j + 1);
                }
                idxR--;
            }
        }
    }

    //unstable
    public static void reOrderArray2(int[] array) {
        int len = array.length;
        if (len == 0) {
            return;
        }
        int start = 0;
        int end = len - 1;
        while (start < end) {
            while (start < end && array[start] % 2 != 0) {
                start++;
            }
            while (start < end && array[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}