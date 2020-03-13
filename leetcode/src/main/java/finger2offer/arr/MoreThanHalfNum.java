package finger2offer.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = moreThanHalfNum1(arr);
        System.out.println(res);
    }

    public static int moreThanHalfNum1(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int cnt = map.get(array[i]);
                map.put(array[i], ++cnt);
            }
        }
        // 推荐使用
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val > array.length / 2) {
                return key;
            }
        }
        return 0;
    }

    public static int moreThanHalfNum2(int[] array) {
        int idx = array.length / 2;
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int res = array[idx];
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res)
                cnt++;
        }
        if (cnt > idx) {
            return res;
        } else {
            return 0;
        }
    }
}