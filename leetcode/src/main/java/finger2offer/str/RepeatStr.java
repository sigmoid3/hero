package finger2offer.str;

import java.util.Arrays;

public class RepeatStr {
    public static void main(String[] args) {
        String str = "aabccc";
        System.out.println(Solution.lengthOfLongestSubstring(str));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        //find the sequence which is the biggest length as return
        int len = s.length();
        int maxCount = 0;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (ifNoRepeat(s.substring(i, j))) {
                    if ((j - i) > maxCount) {
                        maxCount = j - i;
                    }
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }

    public static boolean ifNoRepeat(String str) {
        // cannot directly iterrate string
        char[] a = str.toCharArray();
        for (char item : a) {
            int index = str.indexOf(item);
            for (char s : Arrays.copyOfRange(a, index + 1, a.length)) {
                if (s == item) {
                    return false;
                }
            }
        }
        return true;
    }
}