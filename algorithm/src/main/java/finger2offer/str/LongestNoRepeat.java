package finger2offer.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sandro
 * @Create: 2019-09-20
 * @Description: LongestNoRepeat
 **/
public class LongestNoRepeat {
    public static void main(String[] args) {
        int max_lengthp = 0;
        int[] book = new int[256];
        for (int i = 0; i < 256; i++) {
            book[i] = 0;
        }
        int i = 0;
        int j = 0;
        int k = 3;
        String s = "bccbbbdddddd";
        char[] arr = s.toCharArray();
        int length = arr.length;
        Map<Character, Integer> map = new HashMap<>();
        while (j < length) {
            if (!map.containsKey(arr[j])) {
                map.put(arr[j], 1);
            } else {
                map.put(arr[j], map.get(arr[j]) + 1);
            }
            if (book[(int) arr[j]] == 1) {
                while (arr[i] != arr[j]) {
                    book[(int) arr[i++]] = 0;
                }
                i++;
            }
            book[(int) arr[j]] = 1;
            j++;
            if (j - i > max_lengthp) {
                max_lengthp = j - i;
            }
        }
        max_lengthp = max_lengthp > (j - i) ? max_lengthp : (j - i);
        System.out.println(max_lengthp);
    }
}