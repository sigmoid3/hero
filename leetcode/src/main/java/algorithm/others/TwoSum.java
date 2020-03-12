package algorithm.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution4 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); //其中用到互加性
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {    //通过map检查是否存在符合的值，若存在将索引赋给result[1]
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        while (!input.hasNext("0")) {
            array.add(Integer.valueOf(input.next()));
        }
        Scanner read = new Scanner(System.in);
        Integer target = read.nextInt();
        int[] d = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            d[i] = array.get(i);
        }
        Solution4 sol = new Solution4();
        int[] result = sol.twoSum(d, target);
        System.out.printf("%d\t %d", result[0], result[1]);

    }
}