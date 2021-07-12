package finger2offer.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    static ArrayList<String> ret = new ArrayList<>();

    public static void main(String[] args) {
        int[] array = {3, 2, 321};
        System.out.println(printMinNumber2(array));
    }

    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        permutation(numbers, 0, numbers.length - 1);
        Collections.sort(ret);
        return ret.get(0);
    }

    private static void permutation(int[] array, int cursor, int end) {
        if (cursor == end) {
            StringBuffer str = new StringBuffer();
            for (int val : array) {
                str.append(val);
            }
            ret.add(str.toString());
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!ifExisted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                permutation(array, cursor + 1, end);
                swap(array, cursor, i);
            }
        }
    }

    private static boolean ifExisted(int[] array, int start, int end) {
        for (int i = 0; i < end; i++) {
            if (array[i] == array[end])
                return false;
        }
        return true;
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    //////////////////////////////////////////////////////////////////////

    public static String printMinNumber2(int[] numbers) {
        int len = numbers.length;
        StringBuffer s = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for (int val : list) {
            s.append(val);
        }
        return s.toString();
    }
}