package finger2offer.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumsAppearOne {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        findNumsAppearOne(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    // list.add,delete while the same element
    public static void findNumsAppearOne(int[] array, int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}