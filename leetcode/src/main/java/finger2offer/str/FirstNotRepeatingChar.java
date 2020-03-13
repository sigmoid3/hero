package finger2offer.str;

import java.util.LinkedHashMap;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] strArr = str.toCharArray();
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return pos;
    }
}