package finger2offer.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NineSort {
    public static void main(String[] args) {
        int[] arr = {6, 9, 3, 2, 1, 5, 4, 2, 8, 7};
        // bubble,fastBubble,insert,shell,selection,heap,quick,merge,radix
        int[] ret = quick(arr);
        // change arr to list
        List<Integer> list = new ArrayList<>();
        for (int val : ret) {
            list.add(val);
        }
        System.out.println(list);
    }

    // #1 bubble sort
    public static int[] bubble(int[] arr) {
        int tail = arr.length - 1;
        while (tail > 0) {
            int pos = 0;
            for (int i = 0; i < tail; i++) {
                if (arr[i] > arr[i + 1]) {
                    // pos can be flagged to over process earlier
                    pos = i;
                    swap(arr, i, i + 1);
                }
            }
            tail = pos;
        }
        return arr;
    }

    // #2 fast bubble sort
    public static int[] fastBubble(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int idx;
        while (low < high) {
            // find the biggest one
            for (idx = low; idx < high; idx++) {
                if (arr[idx] > arr[idx + 1]) {
                    swap(arr, idx, idx + 1);
                }
            }
            // find the smallest one
            high--;
            for (idx = high; idx > low; idx--) {
                if (arr[idx] < arr[idx - 1]) {
                    swap(arr, idx, idx - 1);
                }
            }
            low++;
        }
        return arr;
    }

    // #3 insert sort,each time choose the smallest one from i to tail
    public static int[] insert(int[] arr) {
        int i, j, tmp;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                tmp = arr[i]; // remember the element
                for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                    arr[j + 1] = arr[j]; // all will be moved to right for until arr[j]<=tmp
                }
                arr[j + 1] = tmp; // insert the right position
            }
        }
        return arr;
    }

    // #4 shell sort
    public static int[] shell(int[] arr) {
        int tmp;
        int step = arr.length;
        while (true) {
            step /= 2;
            // ensure the number of arr
            for (int i = 0; i < step; i++) {
                // insert arr directly
                for (int j = i + step; j < arr.length; j = j + step) {
                    tmp = arr[j];
                    int k;
                    for (k = j - step; k >= 0; k = k - step) {
                        if (arr[k] > tmp) {
                            arr[k + step] = arr[k];
                        } else {
                            break;
                        }
                    }
                    arr[k + step] = tmp;
                }
            }
            if (step == 1) {
                break;
            }
        }
        return arr;
    }

    // #5 selection sort
    public static int[] selection(int[] arr) {
        int key;
        for (int i = 0; i < arr.length; i++) {
            key = i;
            for (int j = i + 1; j < arr.length; j++) {
                // find the biggest key,put it into right
                if (arr[key] > arr[j]) {
                    key = j;
                }
            }
            if (key != i) {
                swap(arr, key, i);
            }
        }
        return arr;
    }

    // #6 heap sort
    public static int[] heap(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapAdjust(arr, 0, i);
        }
        return arr;
    }

    private static void heapAdjust(int[] arr, int idx, int length) {
        int tmp = arr[idx];
        int child = 2 * idx + 1;
        while (child < length) {
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[idx] < arr[child]) {
                arr[idx] = arr[child];
                idx = child;
                child = 2 * idx + 1;
            } else {
                break;
            }
            arr[idx] = tmp;
        }
    }

    // #7 quick sort
    public static int[] quick(int[] arr) {
        quickAdjust(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickAdjust(int[] arr, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(arr, low, high);
            quickAdjust(arr, low, pivotLoc - 1);
            quickAdjust(arr, pivotLoc + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    // #8 merge sort
    public static int[] merge(int[] arr) {
        mergeAdjust(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeAdjust(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeAdjust(arr, low, mid);
            mergeAdjust(arr, mid + 1, high);
            adjust(arr, low, mid, high);
        }
    }

    private static void adjust(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

    // #9 radix sort
    // sort binary each bit with dls or bls , finally , it can return the correct
    // sequence
    public static int[] radix(int[] arr) {
        int radix = 10, d = 4;
        int[] tempArray = new int[arr.length];
        int[] count = new int[radix];
        int rate = 1;
        for (int i = 0; i < d; i++) {
            Arrays.fill(count, 0);
            System.arraycopy(arr, 0, tempArray, 0, arr.length);
            for (int j = 0; j < arr.length; j++) {
                int subKey = (tempArray[j] / rate) % radix;
                count[subKey]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int m = arr.length - 1; m >= 0; m--) {
                int subKey = (tempArray[m] / rate) % radix;
                arr[--count[subKey]] = tempArray[m];
            }
            rate *= radix;
        }
        return arr;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}