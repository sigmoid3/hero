package finger2offer.arr;

import java.util.ArrayList;
import java.util.List;

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {};
        System.out.println(findNumberWithSum(array, 0));
    }

    private static List<Integer> findNumberWithSum(int[] array, int sum) {
        int len = array.length;
        int head = 0, tail = len - 1;
        List<Integer> res = new ArrayList<Integer>();
        int tmp;
        while (head < tail) {
            tmp = array[head] + array[tail];
            if (tmp == sum) {
                res.add(array[head]);
                res.add(array[tail]);
                break;
            } else if (tmp > sum) {
                tail--;
            } else {
                head++;
            }
        }
        return res;
    }
}