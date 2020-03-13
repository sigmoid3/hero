package finger2offer.search;

public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {2, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6};
        // int res = getNumberOfK1(array, 6);
        int res = getNumberOfK2(array, 2);
        System.out.println(res);
    }

    public static int getNumberOfK2(int[] array, int k) {
        int res = binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
        return res;
    }

    // only for integer
    private static int binarySearch(int[] array, double k) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int getNumberOfK1(int[] array, int k) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int head = getHead(array, k, 0, len - 1);
        int tail = getTail(array, k, 0, len - 1);
        if (head != -1 && tail != -1) {
            return tail - head + 1;
        }
        return 0;
    }

    // recursive
    private static int getHead(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] > k || (mid - 1 >= 0 && array[mid - 1] == k)) {
            return getHead(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getHead(array, k, mid + 1, end);
        } else {
            return mid;
        }
    }

    // loop
    private static int getTail(int[] array, int k, int start, int end) {
        int len = array.length;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k || (mid + 1 < len && array[mid + 1] == k)) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}