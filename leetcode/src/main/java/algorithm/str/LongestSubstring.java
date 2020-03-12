package algorithm.str;

import java.util.Scanner;

/**
 * Created by qmq
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * @ 18-10-12

 **/
class Solution7 {
    public int longestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int max = -1, start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i < s.length()) {
                int index = s.substring(start, i).indexOf(s.charAt(i)); //s中i出现的首次所在位置的索引号
                if (index != -1) {
                    max = Math.max(max, i - start);
                    start += (index + 1);
                } else {
                    max = Math.max(max, i - start);
                }
            }
        }
        return max != -1 ? max : s.length();
    }

    /*public int longSubString(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }*/
}

public class LongestSubstring {
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
        System.out.println(sol.longestSubstring(str));
    }
}
