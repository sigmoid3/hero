package finger2offer.sort;

public class InversePairs {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 0};
        int res = inversePairs2(array);
        System.out.println(res);
    }

    private static int inversePairs1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] tmp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        int cnt = inverseCore(array, tmp, 0, array.length - 1);
        return cnt;
    }

    private static int inverseCore(int[] array, int[] tmp, int start, int end) {
        if (start == end) {
            tmp[start] = array[start];
            return 0;
        }

        int len = (end - start) / 2;
        int left = inverseCore(tmp, array, start, start + len);
        int right = inverseCore(tmp, array, start + len + 1, end);
        int i = start + len;
        int j = end;
        int idxTmp = end;
        int cnt = 0;

        while (i >= start && j >= start + len + 1) {
            if (array[i] > array[j]) {
                tmp[idxTmp--] = array[i--];
                cnt += j - start - len;
                cnt %= 1000000007;
            } else {
                tmp[idxTmp--] = array[j--];
            }
        }

        for (; i >= start; i--) {
            tmp[idxTmp--] = array[i];
        }
        for (; j >= start + len + 1; j--) {
            tmp[idxTmp--] = array[j];
        }

        return left + right + cnt;
    }

    static int cnt;

    public static int inversePairs2(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }

    public static void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    public static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;
                cnt %= 1000000007;
            }
        }

        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}